package org.xxf.temple.service.impl;

import org.springframework.stereotype.Service;
import org.xxf.temple.contants.HandlerType;
import org.xxf.temple.matcher.IMatcher;
import org.xxf.temple.matcher.netty.*;
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
        IMatcher iMatcher = null;
        if(handlerType == HandlerType.NETTY_BOARD_ADD){
            iMatcher = new BoardAddMatcher();
        }else if(handlerType == HandlerType.NETTY_REGISTER){
            iMatcher = new RegisterMatcher();
        }else if(handlerType == HandlerType.NETTY_SIGNAL_STRENGH){
            iMatcher = new SingalStrenchMatcher();
        }else if(handlerType == HandlerType.NETTY_BOARD_EXCEPTION){
            iMatcher = new BoardExceptionMatcher();
        }else if(handlerType == HandlerType.NETTY_PASS_THROUGH){
            iMatcher = new PassThroughMatcher();
        }
        return iMatcher.matcher(query);
    }

}
