package com.hb.takeawayserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hb
 * @creat 2022-10-05-2022/10/5
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespBean {


    Object data;
    String message;
    Integer code;

    public static RespBean success(String msg){
        return new RespBean(null, msg, 200);
    }

    public static RespBean success(String msg, Object data){
        return new RespBean(data, msg, 200);
    }

    public static RespBean error(String msg){
        return new RespBean(null, msg, 500);
    }

}
