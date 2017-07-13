package com.gwf.core.business.bclass.service.impl;

import com.gwf.core.business.bclass.dao.BClassRepository;
import com.gwf.core.business.bclass.entity.BClass;
import com.gwf.core.business.bclass.service.BClassService;
import org.springframework.beans.factory.annotation.Autowired;
import com.gwf.core.business.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by gwf on 2017-7-13 13:56:45.
 */
@Service
@Transactional
public class BClassServiceImpl extends AbstractService<BClass> implements BClassService {
    @Autowired
    private BClassRepository bClassRepository;

}
