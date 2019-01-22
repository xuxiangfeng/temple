package org.xxf.temple.matcher.netty;

import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.util.Util;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 上午 11:54
 */
public class PassThroughMatcher extends NettyMatcher {
    @Override
    public String getCommand() {
        return "ff02";
    }

    @Override
    public String getAddData(NettyQuery query) {
        StringBuilder sb = new StringBuilder();
        sb.append(Util.getIdHex());
        sb.append(query.getPassThrougnMsg());
        return sb.toString();
    }
}
