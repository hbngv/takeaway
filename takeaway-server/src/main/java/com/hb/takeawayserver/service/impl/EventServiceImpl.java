package com.hb.takeawayserver.service.impl;

import com.hb.takeawayserver.pojo.Event;
import com.hb.takeawayserver.mapper.EventMapper;
import com.hb.takeawayserver.service.IEventService;
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
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {

}
