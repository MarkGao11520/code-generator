package com.gwf.core.common.constant;

/**
 * Created with family.
 * author: cy
 * Date: 16/6/23
 * Time: 下午2:06
 * description:
 */
public enum DelStatus {
    //正常0 删除1  审核2
    NORMAL("0"),DELETEED("1"),VERIFY("2");


    private String status;

    public String getStatus(){
        return status;
    }

    private DelStatus(String status){
        this.status = status;
    }
}
