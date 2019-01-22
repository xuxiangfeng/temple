package org.xxf.temple.query.spring;

import lombok.Data;
import org.xxf.temple.query.BaseQuery;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 2:37
 */
@Data
public class ControllerQuery extends BaseQuery {

    private String packageStr;
    private String commit;
    private String name;
    private String date;


}
