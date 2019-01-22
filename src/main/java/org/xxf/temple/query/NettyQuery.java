package org.xxf.temple.query;

import lombok.Data;

/**
 * @author: xxf
 * @date: 2019/1/19 0019 下午 3:11
 */
@Data
public class NettyQuery extends BaseQuery {

    private String deviceNo;

    private Integer boardId;

    private Integer signalStrengh;

    private Integer isException;

    private String passThrougnMsg;


}
