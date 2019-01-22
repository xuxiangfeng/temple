package org.xxf.temple.util;

import org.xxf.temple.manager.IdManager;

import java.util.UUID;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 上午 11:55
 */
public class Util {

    public static String getIdHex(){
        return ByteUtil.decimal2fitHex(IdManager.getInstance().createId(),4);
    }

}
