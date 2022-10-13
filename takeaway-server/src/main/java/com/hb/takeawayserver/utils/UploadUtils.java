package com.hb.takeawayserver.utils;

import com.hb.takeawayserver.Exception.FileFormatNotMathException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author hb
 * @creat 2022-10-05-2022/10/5
 **/
public class UploadUtils {

    static Set<String> imgType = new HashSet<>(Arrays.asList("jpg","png","gif","psd","tif"));
    static final String PHOTO_PATH = "D:\\takeaway\\upload\\";

    public static String uploadImage(MultipartFile multipartFile) throws IOException, FileFormatNotMathException {
        String oldName = multipartFile.getOriginalFilename();
        /**
         * 可扩展 多次提交上传相同文件的处理；
         */
//        String shaValue = DigestUtil.sha256Hex(multipartFile.getBytes());
//        //相同的文件每次上传has256值都是一样的,可以根据该值判断文件是否存在
//        if (shaValue.equals("数据库中的has256值")) {
//            return "该文件已存在";
//        }
        String imgSuffix = oldName.substring(oldName.lastIndexOf("."));
        if(!imgType.contains(imgSuffix)){
            throw new FileFormatNotMathException("图片格式不正确");
        }

        String newFilename = UUID.randomUUID() +imgSuffix;
        String dateFormat = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        File targetPath = new File(PHOTO_PATH, dateFormat);
        if (!targetPath.exists()){
            targetPath.mkdirs();
        }
        File targetFilename = new File(targetPath, newFilename);
        multipartFile.transferTo(targetFilename);
        return "upload/"+dateFormat+"/"+newFilename;
    }
}


