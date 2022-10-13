package com.hb.takeawayserver.service.impl;

import com.hb.takeawayserver.pojo.Menu;
import com.hb.takeawayserver.mapper.MenuMapper;
import com.hb.takeawayserver.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
