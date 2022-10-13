package com.hb.takeawayserver.Exception;



/**
 * @author hb
 * @creat 2022-10-05-2022/10/5
 *
 * 文件格式不匹配异常
 **/
public class FileFormatNotMathException extends Exception {

    public FileFormatNotMathException() {
    }

    public FileFormatNotMathException(String message) {
        super(message);
    }
}
