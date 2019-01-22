package org.xxf.temple.matcher.spring;

import org.xxf.temple.matcher.FileMatcher;
import org.xxf.temple.query.spring.IServiceQuery;
import org.xxf.temple.util.TempleUtil;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 5:20
 */
public class IServiceMatcher extends FileMatcher<IServiceQuery> {
    public IServiceMatcher(String regiexStr) {
        super(regiexStr);
    }

    @Override
    public String getTempleName() {
        return "JavaIService.tpl";
    }

    @Override
    public String getFileName(IServiceQuery query) {
        return String.format("%s.java",TempleUtil.iServiceName(query.getName()));
    }
}
