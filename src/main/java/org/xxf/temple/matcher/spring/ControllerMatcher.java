package org.xxf.temple.matcher.spring;

import org.xxf.temple.matcher.FileMatcher;
import org.xxf.temple.query.spring.ControllerQuery;
import org.xxf.temple.util.TempleUtil;

import java.io.File;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 下午 2:36
 */
public class ControllerMatcher extends FileMatcher<ControllerQuery> {

    public ControllerMatcher(String regiexStr) {
        super(regiexStr);
    }

    @Override
    public String getTempleName() {
        return "JavaController.tpl";
    }

    @Override
    public String getFileName(ControllerQuery query) {
        return String.format("%sController.java",TempleUtil.firstUpper(query.getName()));
    }
}
