package com.gwf.core.common.constant;

/**
 * Created with family.
 * author: cy
 * Date: 16/6/23
 * Time: 下午2:06
 * description:
 */
public enum FlagStatus {
    //启用1  停用0
    NORMAL("1"),ABNORMAL("0");


    private String status;

    public String getStatus(){
        return status;
    }

    private FlagStatus(String status){
        this.status = status;
    }
}
