package org.xxf.temple.matcher.netty;

import org.xxf.temple.query.NettyQuery;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 上午 11:39
 */
public class RegisterMatcher extends NettyMatcher {
    @Override
    public String getCommand() {
        return "0101";
    }

    @Override
    public String getAddData(NettyQuery query) {
        StringBuilder sb = new StringBuilder();
        sb.append(query.getDeviceNo()).append("0");
        sb.append("01");
        return sb.toString();
    }
}
