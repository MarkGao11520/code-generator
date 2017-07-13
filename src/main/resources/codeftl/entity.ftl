package ${basePackage}.entity;

import ${corePackage}.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
* Created with ${author} on ${.now}.
*/
@Entity
@Table(name = "${table.tableName}")
public class ${table.entityName} extends IdEntity<${table.entityName}> {
    public ${table.entityName}(){
    }

    public ${table.entityName}(<#list table.columnModels as item><#if item_index!=0>,</#if>${item.javaType} ${item.columnNameLowerCamel}</#list>){
    <#list table.columnModels as item>
        this.${item.columnNameLowerCamel}=${item.columnNameLowerCamel};
    </#list>
    }

    <#list table.columnModels as item>
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

    <#list table.columnModels as item>
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

