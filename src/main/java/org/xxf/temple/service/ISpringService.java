package org.xxf.temple.service;

import org.xxf.temple.query.spring.ControllerQuery;
import org.xxf.temple.query.spring.IServiceQuery;
import org.xxf.temple.query.spring.QuickQuery;
import org.xxf.temple.query.spring.ServiceQuery;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 3:15
 */
public interface ISpringService {
    void createController(ControllerQuery query);

    void createService(ServiceQuery query);

    void createIService(IServiceQuery query);

    void quickCreate(QuickQuery query);
}
