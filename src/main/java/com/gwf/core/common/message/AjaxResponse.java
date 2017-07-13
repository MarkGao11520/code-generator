package com.gwf.core.common.message;

/**
 * Created by lcy on 16/8/2.
 */
public class AjaxResponse {


    private boolean success = true;

    private String message ;

    private Object result;


    public AjaxResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功提示
     * @param message
     * @param result
     */
    public void  setSuccessMessage(String message, Object result){
        this.setMessage(message);
        this.setResult(result);
    }
    /**
     * 失败提示
     * @param message
     * @param result
     */
    public void  setErrorMessage(String message, Object result){
        this.setSuccess(false);
        this.setMessage(message);
        this.setResult(result);
    }
    //错误代码 内部类
    public static class ErrorAjaxCode {
        //无权限错误代码
        public static String ERROR_CODE_NOAUTHORICATION = "noauthorication";
        //无认证错误代码
        public static String ERROR_CODE_NOAUTHENTICATION = "noauthentication";

    }

}
