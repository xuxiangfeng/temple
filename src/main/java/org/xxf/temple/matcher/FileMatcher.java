package org.xxf.temple.matcher;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xxf.temple.matcher.IMatcher;
import org.xxf.temple.query.BaseQuery;
import org.xxf.temple.util.FileUtil;
import org.xxf.temple.util.ReflectUtil;
import org.xxf.temple.util.TempleUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: xxf
 * @date: 2019/1/21 0021 下午 5:21
 */
public abstract class FileMatcher<T extends BaseQuery> implements IMatcher<T> {

    private String regiexStr;

    protected Log log = LogFactory.getLog(FileMatcher.class);

    private final String TPL_PATH = "src/main/resources/templates/";
    private final String FILE_PATH = "result/";
    private final String METHOD_SPACE = "::";
    private final String METHOD_SPACE_REGIX = "::";

    public FileMatcher(String regiexStr){
        this.regiexStr = regiexStr;
    }

    @Override
    public String matcher(T query) {
        String templeName = TPL_PATH + getTempleName();
        if(StringUtils.isEmpty(templeName)){
            return onFailed("file name null");
        }
        String content = FileUtil.readToString(templeName);
        if(StringUtils.isEmpty(content)){
            return onFailed("file content error");
        }

        try {
            String result = transContent(content,query);
            String fileName = FILE_PATH + getFileName(query);
            FileUtil.createNewFile(fileName,result);
            return onSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return onFailed("file trans error");
        }
    }

    public abstract String getTempleName();

    public abstract String getFileName(T query);

    private String transContent(String content,T query) throws Exception{
        String result = new String(content);
        Pattern pattern = Pattern.compile(regiexStr);
        Matcher matcher = pattern.matcher(content);
        Set<String> groupItems = new HashSet<>();
        while (matcher.find()){
            String key = matcher.group();
            if(!groupItems.contains(key)){
                groupItems.add(key);
            }
        }
        Map<String,String> params = ReflectUtil.objectToMap(query);
        Iterator<String> iterator = groupItems.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = getGroupItemValue(key,params);
            result = result.replaceAll("<<"+key+">>",value);
        }
        return result;
    }

    private String getGroupItemValue(String key,Map<String,String> params) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String result = "";
        if(key.indexOf(METHOD_SPACE) > 0){
            String[] keyArr = key.split(METHOD_SPACE_REGIX);
            if(params.containsKey(keyArr[0].trim())){
                result = params.get(keyArr[0].trim());
                for(int i  = 1;i<keyArr.length;i++){
                    result = TempleUtil.checkValue(result,keyArr[i].trim());
                }
            }
        }else{
            if(params.containsKey(key.trim())){
                result = params.get(key.trim());
            }
        }
        return result;
    }


    private String onFailed(String msg){
        return msg;
    }

    private String onSuccess(){
        return "success";
    }

}
