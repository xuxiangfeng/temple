package org.xxf.temple.handler.netty;

import org.xxf.temple.handler.IHandler;
import org.xxf.temple.query.BaseQuery;
import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.util.ByteUtil;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:06
 */
public class BoardAddHandler extends NettyHandler {

    @Override
    public String getCommand() {
        return "ff00";
    }

    @Override
    public String getAddData(NettyQuery query) {
        Integer boardId = query.getBoardId();
        return ByteUtil.decimal2fitHex(boardId);
    }
}
