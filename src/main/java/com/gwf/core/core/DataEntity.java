package com.gwf.core.core;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with family.
 * author: cy
 * Date: 16/6/23
 * Time: 上午10:04
 * description: data 实体  常用属性
 */
@MappedSuperclass
public abstract class DataEntity<T>  implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String remarks;	// 备注
    protected String createBy;	// 创建者
    protected Date createDate;// 创建日期
    protected String updateBy;	// 更新者
    protected Date updateDate;// 更新日期
    protected String delFlag ; // 删除标记（0：正常；1：删除；2：审核）
    protected String flag ; // 启用标记（0：停用；1：启用）


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }



    public DataEntity() {
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /*public void setCurrentPersistOperation(User user){
        this.setCreateBy(user.getId());
        this.setCreateDate(new Date());
        this.setUpdateBy(user.getId());
        this.setUpdateDate(new Date());
        this.setFlag(FlagStatus.NORMAL.getStatus());
        this.setDelFlag(DelStatus.NORMAL.getStatus());
    }
    public void setCurrentMergeOperation(User user){
        this.setUpdateBy(user.getId());
        this.setUpdateDate(new Date());
    }*/

    /**
     * 设置删除
     */
    public void setDeleted(){
        this.setDelFlag("1");
    }


}
