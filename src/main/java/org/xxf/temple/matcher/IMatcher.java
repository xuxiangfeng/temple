package org.xxf.temple.matcher;

import org.xxf.temple.query.BaseQuery;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:07
 */
public interface IMatcher<T extends BaseQuery> {

    String matcher(T t);
}
