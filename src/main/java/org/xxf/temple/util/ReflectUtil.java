package org.xxf.temple.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxf
 * @date: 2019/1/22 0022 上午 11:16
 */
public class ReflectUtil {

    public static Map<String,String> objectToMap(Object object) throws IllegalAccessException {
        if(object == null){
            return null;
        }
        Map result = new HashMap<String,String>();
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            result.put(field.getName(), field.get(object));
        }
        return result;
    }

}
