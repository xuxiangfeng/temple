package org.xxf.temple.matcher.netty;

import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.util.ByteUtil;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 上午 11:47
 */
public class SingalStrenchMatcher extends NettyMatcher {
    @Override
    public String getCommand() {
        return "0104";
    }

    @Override
    public String getAddData(NettyQuery query) {
        return ByteUtil.decimal2fitHex(query.getSignalStrengh(),2);
    }
}
