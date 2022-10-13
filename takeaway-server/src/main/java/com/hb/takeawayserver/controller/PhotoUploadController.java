package com.hb.takeawayserver.controller;

import com.hb.takeawayserver.Exception.FileFormatNotMathException;
import com.hb.takeawayserver.pojo.RespBean;
import com.hb.takeawayserver.utils.UploadUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author hb
 * @creat 2022-10-05-2022/10/5
 **/

@RestController
@RequestMapping("/upload")
public class PhotoUploadController {

    @PostMapping("/photo")
    public RespBean uploadFile(MultipartFile file, HttpServletRequest request) {
        String path = null;
        try {
            path = UploadUtils.uploadImage(file);
        } catch (IOException e) {
            return RespBean.error("文件上失败");
        } catch (FileFormatNotMathException e) {
            return RespBean.error("文件格式不匹配");
        }
        return RespBean.success("文件上传成功", path);
    }
}
