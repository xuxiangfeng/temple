package org.xxf.temple.handler.netty;

import org.xxf.temple.handler.IHandler;
import org.xxf.temple.query.NettyQuery;
import org.xxf.temple.util.ByteUtil;
import org.xxf.temple.util.CRC16Utils;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 4:02
 */
public abstract class NettyHandler implements IHandler<NettyQuery> {

    private final String HEX_TOP = "3AA3000000";

    @Override
    public String temple(NettyQuery query) {
        StringBuilder sb = new StringBuilder(HEX_TOP);
        String command = getCommand();
        String appData = getAddData(query);
        int length = (command.length() + appData.length())/2;
        String comLen = ByteUtil.decimal2fitHex(length,4);
        sb.append(comLen).append(command).append(appData);

        String localCrc16 = CRC16Utils.getCRC16(ByteUtil.hexStr2bytes(sb.toString()));
        sb.append(localCrc16);

        return sb.toString();
    }

    public abstract String getCommand();

    public abstract String getAddData(NettyQuery query);
}
