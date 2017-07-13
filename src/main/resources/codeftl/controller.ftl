package ${basePackage}.controller;
import ${corePackage}.result.Result;
import ${corePackage}.result.ResultGenerator;
import ${basePackage}.entity.${table.entityName};
import ${basePackage}.service.${table.entityName}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* Created by ${author} on ${.now}.
*/
@RestController
@RequestMapping("${table.entityName?uncap_first}")
public class ${table.entityName}Controller {
    @Autowired
    private ${table.entityName}Service ${table.entityName?uncap_first}Service;

    @PostMapping("/add")
    public Result add(${table.entityName} ${table.entityName?uncap_first}) {
        ${table.entityName?uncap_first}Service.save(${table.entityName?uncap_first});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Integer id) {
        ${table.entityName?uncap_first}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(${table.entityName} ${table.entityName?uncap_first}) {
        ${table.entityName?uncap_first}Service.update(${table.entityName?uncap_first});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        ${table.entityName} ${table.entityName?uncap_first} = ${table.entityName?uncap_first}Service.findById(id);
        return ResultGenerator.genSuccessResult(${table.entityName?uncap_first});
    }

    @PostMapping("/list")
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<${table.entityName}> list = ${table.entityName?uncap_first}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
