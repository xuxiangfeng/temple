package org.xxf.temple.util;

/**
 * @author cheng
 */

public enum ResultCode {
	SUCCESS(0, "success"),
	
	/**
	 * 通用异常
	 */
	SYSTEM_ERROR(10000, "内部异常出错"), 
	DAO_ERROR(10001, "数据层异常出错"), 
	ILLEGAL_ARGUMENT(10002, "非法参数"),
	ERROR_SELECT_IS_NULL(10005,"该数据已逃离地球,请重试"),
	ERROR_SAVE(10008,"保存失败,请重试"),
	ERROR_UPDATE(10009,"更新失败,请重试"),
	ERROR_DELETE(100010,"删除失败,请重试"),

	;



	private int code;

	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return code + ":" + msg;
	}

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
