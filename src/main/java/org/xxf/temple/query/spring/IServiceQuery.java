package org.xxf.temple.query.spring;

import lombok.Data;
import org.xxf.temple.query.BaseQuery;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 5:19
 */
@Data
public class IServiceQuery extends BaseQuery {

    private String packageStr;
    private String commit;
    private String name;
    private String date;

}
