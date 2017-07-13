package ${basePackage}.service;

import ${entityPackage}.${modelNameUpperCamel};

import com.isoft.common.component.PageUtil;
import com.isoft.common.model.PersistModel;
import com.isoft.sys.user.entity.User;

import java.util.List;

/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service{
    /**
    * 根据主键唯一查找
    * @param businessId
    * @return
    */
    ${modelNameUpperCamel} selectOne(String businessId);

    /**
    * 根据条件分页查找
    * @param pageUtil
    * @param model
    * @return
    */
    List<${modelNameUpperCamel}> query${modelNameUpperCamel}sByPagination(PageUtil pageUtil,${modelNameUpperCamel} model);

    /**
    * 根据条件查找全部
    * @param model
    * @return
    */
    List<${modelNameUpperCamel}> query${modelNameUpperCamel}s(${modelNameUpperCamel} model);

    /**
    * 插入
    * @param model
    * @return
    */
    PersistModel persist(${modelNameUpperCamel} model);
}
