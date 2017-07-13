package com.gwf.core.business.core;



import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created with family.
 * author: cy
 * Date: 16/6/2
 * Time: 上午9:15
 * description: id entity
 */
@MappedSuperclass
public abstract class IdEntity<T> extends DataEntity<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    protected String businessId;		// 编号

    public IdEntity() {
        super();
    }

    /**
     * mybatis 不能集成jpa注解   @prepersist 进不来

    @PrePersist
    public void prePersist(){
        User user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user;
            this.createBy = user;
        }
        this.id = IdGen.uuid();
    }*/

    @Id
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }



    /**
     * 通用设置ID
     */
    public void setCommonBusinessId(){
        this.setBusinessId(IdGen.uuid());
    }
}