package org.xxf.temple.service.impl;

import org.springframework.stereotype.Service;
import org.xxf.temple.contants.HandlerType;
import org.xxf.temple.handler.IHandler;
import org.xxf.temple.handler.netty.BoardAddHandler;
import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.service.IHandlerService;


/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:17
 */
@Service
public class HandlerService implements IHandlerService {

    @Override
    public String nettyHandler(NettyQuery query) throws Exception{
        Integer handlerType = query.getHandlerType();
        IHandler IHandler = null;
        if(handlerType == HandlerType.NETTY_BOARD_ADD){
            IHandler = new BoardAddHandler();
        }
        return IHandler.temple(query);
    }

}
