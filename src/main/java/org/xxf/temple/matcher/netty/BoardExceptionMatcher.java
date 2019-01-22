package org.xxf.temple.matcher.netty;

import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.util.ByteUtil;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 上午 11:50
 */
public class BoardExceptionMatcher extends NettyMatcher {
    @Override
    public String getCommand() {
        return "0105";
    }

    @Override
    public String getAddData(NettyQuery query) {
        StringBuilder sb = new StringBuilder();
        sb.append(ByteUtil.decimal2fitHex(query.getIsException(),2));
        sb.append("00000000");
        return sb.toString();
    }
}
