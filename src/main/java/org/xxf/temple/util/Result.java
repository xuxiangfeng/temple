package org.xxf.temple.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

/**
 * 统一返回格式
 * @author fangcheng
 */
@Getter
@Setter
@ToString
public class Result<T> {

    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体的内容.
     */
    private T data;

    public Result() {
        this.code = ResultCode.SUCCESS.getCode();
    }

    public void putError(ResultCode error) {
        this.putError(error, (String)null);
    }

    public void putError(ResultCode error, String msg) {
        this.code = error.getCode();
        if(StringUtils.isBlank(msg)) {
            this.msg = error.getMsg();
        } else {
            this.msg = msg;
        }

    }

    public void putError(Result<?> error) {
        this.code = error.getCode();
        if(StringUtils.isBlank(error.getMsg())) {
            this.msg = error.getMsg();
        } else {
            this.msg = error.getMsg();
        }

    }
}
