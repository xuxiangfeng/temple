package org.xxf.temple.handler;

import org.xxf.temple.query.BaseQuery;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:07
 */
public interface IHandler<T extends BaseQuery> {

    String temple(T t);
}
