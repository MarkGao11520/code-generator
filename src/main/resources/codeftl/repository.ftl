package ${basePackage}.dao;

import ${entityPackage}.${modelNameUpperCamel};

import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.List;

/**
* Created with ${author} on ${date}.
*/
@Repository
public interface ${modelNameUpperCamel}Repository extends Mapper<${modelNameUpperCamel}> {

    /**
    * 根据条件查找
    * @param param
    * @return
    */
    @Select("select * from ${table_name}")
    @ResultMap(value = "BaseResultMap" )
    List<${modelNameUpperCamel}> query${modelNameUpperCamel}s(Map<String,Object> param);
}

