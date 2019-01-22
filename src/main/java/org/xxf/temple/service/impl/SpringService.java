package org.xxf.temple.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.xxf.temple.matcher.IMatcher;
import org.xxf.temple.matcher.spring.ControllerMatcher;
import org.xxf.temple.query.spring.ControllerQuery;
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

}
