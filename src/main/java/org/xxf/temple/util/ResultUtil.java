package org.xxf.temple.util;

import org.apache.commons.lang.StringUtils;

/**
 * 公共返回类
 *
 * @author fangcheng
 */
public class ResultUtil {

    public static <T extends Object> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result<?> putError(ResultCode error) {
        Result<?> result = new Result<>();
        result.setCode(error.getCode());
        result.setMsg(error.getMsg());
        return result;
    }

    public static Result<Object> putError(ResultCode error, String msg) {
        Result<Object> result = new Result<>();
        result.setCode(error.getCode());
        if (StringUtils.isBlank(msg)) {
            result.setMsg(error.getMsg());
        } else {
            result.setMsg(msg);
        }
        return result;
    }
}
