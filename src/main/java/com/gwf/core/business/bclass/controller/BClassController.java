package com.gwf.core.business.bclass.controller;
import com.gwf.core.business.core.Result;
import com.gwf.core.business.core.ResultGenerator;
import com.gwf.core.business.bclass.entity.BClass;
import com.gwf.core.business.bclass.service.BClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* Created by gwf on 2017-7-13 13:56:45.
*/
@RestController
@RequestMapping("bClass")
public class BClassController {
    @Autowired
    private BClassService bClassService;

    @PostMapping("/add")
    public Result add(BClass bClass) {
        bClassService.save(bClass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(Integer id) {
        bClassService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(BClass bClass) {
        bClassService.update(bClass);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(Integer id) {
        BClass bClass = bClassService.findById(id);
        return ResultGenerator.genSuccessResult(bClass);
    }

    @PostMapping("/list")
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<BClass> list = bClassService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
