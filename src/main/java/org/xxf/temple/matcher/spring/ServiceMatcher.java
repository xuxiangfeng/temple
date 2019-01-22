package org.xxf.temple.matcher.spring;

import org.xxf.temple.matcher.FileMatcher;
import org.xxf.temple.query.spring.ServiceQuery;
import org.xxf.temple.util.TempleUtil;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 5:07
 */
public class ServiceMatcher extends FileMatcher<ServiceQuery> {

    public ServiceMatcher(String regiexStr) {
        super(regiexStr);
    }

    @Override
    public String getTempleName() {
        return "JavaService.tpl";
    }

    @Override
    public String getFileName(ServiceQuery query) {
        return String.format("%s.java",TempleUtil.serviceName(query.getName()));
    }
}
