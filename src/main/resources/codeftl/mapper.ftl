<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${mapperPackage}.${modelNameUpperCamel}Repository">
    <resultMap id="BaseResultMap" type="${entityPackage}.${modelNameUpperCamel}">
    <#list columnList as item>
        <#if item.isKey>
            <id column="${item.colName}" jdbcType="${item.typeNameUpper}" property="${item.columnNameLowerCamel}"/>
        </#if>
        <#if !item.isKey>
            <result column="${item.colName}" jdbcType="${item.typeNameUpper}" property="${item.columnNameLowerCamel}"/>
        </#if>
    </#list>
    </resultMap>
</mapper>