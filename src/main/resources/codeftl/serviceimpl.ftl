package ${basePackage}.service.impl;

import ${entityPackage}.${modelNameUpperCamel};
import ${mapperPackage}.${modelNameUpperCamel}Repository;
import ${servicePackage}.${modelNameUpperCamel}Service;

import com.isoft.common.model.PersistModel;
import org.springframework.stereotype.Service;
import com.isoft.common.component.PageUtil;
import com.isoft.sys.util.UserUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.isoft.sys.user.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.NOT_SUPPORTED)
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service{
    @Autowired
    private ${modelNameUpperCamel}Repository ${modelNameLowerCamel}Repository;

    @Override
    public ${modelNameUpperCamel} selectOne(String businessId){
        return ${modelNameLowerCamel}Repository.selectByPrimaryKey(businessId);
    }

    @Override
    public List<${modelNameUpperCamel}> query${modelNameUpperCamel}sByPagination(PageUtil pageUtil, ${modelNameUpperCamel} model) {
        Map param = new HashMap<String,Object>();
        return ${modelNameLowerCamel}Repository.query${modelNameUpperCamel}s(param);
    }

    @Override
    public List<${modelNameUpperCamel}> query${modelNameUpperCamel}s(${modelNameUpperCamel} model) {
        Map param = new HashMap<String,Object>();
        return ${modelNameLowerCamel}Repository.query${modelNameUpperCamel}s(param);
    }


    @Override
    public PersistModel persist(${modelNameUpperCamel} model){
        model.setCommonBusinessId();
        UserUtils.setCurrentPersistOperation(model);
        int line = ${modelNameLowerCamel}Repository.insertSelective(model);
        //FamilyLogger.sysInfo(UserUtils.getUser().getBusinessId(),UserUtils.getUser().getLoginName()+"新增了ID为"+user.getBusinessId()+"的用户");
        return new PersistModel(line);
    }
}
