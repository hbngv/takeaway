package com.hb.takeawayserver.service;

import com.hb.takeawayserver.pojo.RespBean;
import com.hb.takeawayserver.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hb.takeawayserver.pojo.UserVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hb
 * @since 2022-10-05
 */
public interface IUserService extends IService<User> {

    RespBean login(UserVO user);

    User getUserByUserName(String username);
}
