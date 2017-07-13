package ${basePackage}.entity;

import com.isoft.common.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
* Created with ${author} on ${date}.
*/
@Entity
@Table(name = "${table_name}")
public class ${modelNameUpperCamel} extends IdEntity<${modelNameUpperCamel}> {
    public ${modelNameUpperCamel}(){
    }

    public ${modelNameUpperCamel}(<#list columnList as item><#if item_index!=0>,</#if>${item.javaType} ${item.columnNameLowerCamel}</#list>){
    <#list columnList as item>
        this.${item.columnNameLowerCamel}=${item.columnNameLowerCamel};
    </#list>
    }

    <#list columnList as item>
    <#if item.columnNameLowerCamel!='businessId'&&
         item.columnNameLowerCamel!='remarks'&&
         item.columnNameLowerCamel!='createBy'&&
         item.columnNameLowerCamel!='createDate'&&
         item.columnNameLowerCamel!='updateBy'&&
         item.columnNameLowerCamel!='updateDate'&&
         item.columnNameLowerCamel!='delFlag'&&
         item.columnNameLowerCamel!='flag'>
    private ${item.javaType} ${item.columnNameLowerCamel};
    </#if>
    </#list>

    <#list columnList as item>
    <#if item.columnNameLowerCamel!='businessId'&&
         item.columnNameLowerCamel!='remarks'&&
         item.columnNameLowerCamel!='createBy'&&
         item.columnNameLowerCamel!='createDate'&&
         item.columnNameLowerCamel!='updateBy'&&
         item.columnNameLowerCamel!='updateDate'&&
         item.columnNameLowerCamel!='delFlag'&&
         item.columnNameLowerCamel!='flag'>
    public ${item.javaType} get${item.columnNameUpperCamel}(){
        return ${item.columnNameLowerCamel};
    }
    public void set${item.columnNameUpperCamel}(${item.javaType} ${item.columnNameLowerCamel}){
        this.${item.columnNameLowerCamel}=${item.columnNameLowerCamel};
    }
    </#if>
    </#list>
}

