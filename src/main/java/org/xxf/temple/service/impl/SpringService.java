package org.xxf.temple.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xxf.temple.matcher.IMatcher;
import org.xxf.temple.matcher.spring.ControllerMatcher;
import org.xxf.temple.matcher.spring.IServiceMatcher;
import org.xxf.temple.matcher.spring.ServiceMatcher;
import org.xxf.temple.query.spring.ControllerQuery;
import org.xxf.temple.query.spring.IServiceQuery;
import org.xxf.temple.query.spring.QuickQuery;
import org.xxf.temple.query.spring.ServiceQuery;
import org.xxf.temple.service.ISpringService;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 3:15
 */
@Service
public class SpringService implements ISpringService {

    @Value("${pattern.temple.content}")
    private String regix;

    @Override
    public void createController(ControllerQuery query){
        IMatcher matcher = new ControllerMatcher(regix);
        matcher.matcher(query);
    }

    @Override
    public void createService(ServiceQuery query){
        IMatcher matcher = new ServiceMatcher(regix);
        matcher.matcher(query);
    }

    @Override
    public void createIService(IServiceQuery query){
        IMatcher matcher = new IServiceMatcher(regix);
        matcher.matcher(query);
    }

    @Override
    public void quickCreate(QuickQuery query){
        (new ControllerMatcher(regix)).matcher(query.toController());
        (new ServiceMatcher(regix)).matcher(query.toService());
        (new IServiceMatcher(regix)).matcher(query.toISerivce());
    }



}
