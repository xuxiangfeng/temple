package org.xxf.temple.service;

import org.xxf.temple.query.NettyQuery;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:17
 */
public interface IHandlerService {
    String nettyHandler(NettyQuery query) throws Exception;
}
