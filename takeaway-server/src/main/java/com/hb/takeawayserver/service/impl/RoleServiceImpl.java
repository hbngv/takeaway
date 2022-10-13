package com.hb.takeawayserver.service.impl;

import com.hb.takeawayserver.pojo.Role;
import com.hb.takeawayserver.mapper.RoleMapper;
import com.hb.takeawayserver.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hb
 * @since 2022-10-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
