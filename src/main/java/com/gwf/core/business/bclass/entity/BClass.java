package com.gwf.core.business.bclass.entity;

import com.gwf.core.business.core.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
* Created with gwf on 2017-7-13 13:56:44.
*/
@Entity
@Table(name = "b_class")
public class BClass extends IdEntity<BClass> {
    public BClass(){
    }

    public BClass(String businessId,String code,String className,Integer studentNum,String createBy,String updateBy,String delFlag,String flag,String remarks,Date updateDate,Date createDate){
        this.businessId=businessId;
        this.code=code;
        this.className=className;
        this.studentNum=studentNum;
        this.createBy=createBy;
        this.updateBy=updateBy;
        this.delFlag=delFlag;
        this.flag=flag;
        this.remarks=remarks;
        this.updateDate=updateDate;
        this.createDate=createDate;
    }

    private String code;
    private String className;
    private Integer studentNum;

    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code=code;
    }
    public String getClassName(){
        return className;
    }
    public void setClassName(String className){
        this.className=className;
    }
    public Integer getStudentNum(){
        return studentNum;
    }
    public void setStudentNum(Integer studentNum){
        this.studentNum=studentNum;
    }
}

