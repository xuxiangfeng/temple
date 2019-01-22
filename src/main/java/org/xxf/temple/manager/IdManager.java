package org.xxf.temple.manager;

import org.apache.commons.logging.LogFactory;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 下午 2:02
 */
public class IdManager {
    private static IdManager ourInstance = new IdManager();

    public static IdManager getInstance() {
        return ourInstance;
    }

    private IdManager() {
        count = 0;
    }

    private Integer count;

    public Integer createId(){
        count++;
        return count;
    }

    @Override
    protected void finalize() throws Throwable {
        LogFactory.getLog(IdManager.class).info("IdManager reset");
        super.finalize();
    }
}
