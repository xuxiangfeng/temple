package org.xxf.temple.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 上午 11:30
 */
public class TempleUtil {

    public static String firstUpper(String value){
        if(value == null || value.length() == 0){
            return "";
        }
        if(Character.isUpperCase(value.charAt(0))){
            return value;
        }

        return (new StringBuilder()).append(Character.toUpperCase(value.charAt(0))).append(value.substring(1)).toString();
    }

    public static String controllerName(String value){
        return String.format("%sController",firstUpper(value));
    }

    public static String serviceName(String value){
        return String.format("%sService",firstUpper(value));
    }

    public static String iServiceName(String value){
        return String.format("I%sService",firstUpper(value));
    }

    public static String checkValue(String value,String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TempleUtil.class.getMethod(methodName,new Class[]{String.class});
        return (String)method.invoke(null,value);
    }



}
