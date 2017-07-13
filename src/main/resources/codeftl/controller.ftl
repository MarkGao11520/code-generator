package ${basePackage}.controller;

import ${entityPackage}.${modelNameUpperCamel};
import ${servicePackage}.${modelNameUpperCamel}Service;

import com.isoft.sys.user.entity.User;
import com.isoft.common.model.PersistModel;
import com.isoft.sys.util.UserUtils;
import com.isoft.common.constant.MessageConstant;
import com.isoft.common.message.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import com.isoft.common.controller.PaginationController;

import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@Controller
@RequestMapping("/${modelNameUpperCamel}")
public class ${modelNameUpperCamel}Controller extends PaginationController<${modelNameUpperCamel}>{
    @Autowired
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    /**
    * 插入
    * @param ${modelNameLowerCamel}
    * @param ar
    * @return
    */
    @RequestMapping("/add")
    @ResponseBody
    public AjaxResponse add(${modelNameUpperCamel} ${modelNameLowerCamel},AjaxResponse ar) {
        PersistModel result = ${modelNameLowerCamel}Service.persist(${modelNameLowerCamel});
        ar.setSuccessMessage(MessageConstant.MESSAGE_ALERT_SUCCESS,result);
        return ar;
    }

    /**
    * 根据主键唯一查找
    * @param businessId
    * @param ar
    * @return
    */
    @RequestMapping("/one")
    @ResponseBody
    public AjaxResponse queryOne(String businessId,AjaxResponse ar) {
        ar.setSuccessMessage(MessageConstant.MESSAGE_ALERT_SUCCESS,${modelNameLowerCamel}Service.selectOne(businessId));
        return ar;
    }


    /**
    * 根据条件分页查询
    * @param param
    * @param ar
    * @return
    */
    @RequestMapping("/query${modelNameUpperCamel}sByPagination")
    @ResponseBody
    public AjaxResponse query${modelNameUpperCamel}sByPagination(${modelNameUpperCamel} param,AjaxResponse ar) {
        param.setCreateBy(UserUtils.getUser().getBusinessId());
        ar.setSuccessMessage(MessageConstant.MESSAGE_ALERT_SUCCESS,${modelNameLowerCamel}Service.query${modelNameUpperCamel}sByPagination(getPaginationUtility(),param));
        return ar;
    }

    /**
    * 根据条件查询
    * @param param
    * @param ar
    * @return
    */
    @RequestMapping("/query${modelNameUpperCamel}s")
    @ResponseBody
    public AjaxResponse query${modelNameUpperCamel}s(${modelNameUpperCamel} param,AjaxResponse ar) {
        param.setCreateBy(UserUtils.getUser().getBusinessId());
        ar.setSuccessMessage(MessageConstant.MESSAGE_ALERT_SUCCESS,${modelNameLowerCamel}Service.query${modelNameUpperCamel}s(param));
        return ar;
    }
}
