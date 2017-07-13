package com.gwf.core.business.code.service;



import com.gwf.core.business.code.model.CodeSchema;
import com.gwf.core.business.code.model.CodeTable;

import java.util.List;

/**
 * Created by lcy on 17/6/28.
 */
public interface CodeService {


    /**
     * 获取 codesTable 通过 schema
     * @param schema
     * @return
     */
    public List<CodeTable> getCodeTablesBySchema(CodeSchema schema);

    /**
     * 构建代码库
     * @param codeSchema
     * @return
     */
    String generateCode(CodeSchema codeSchema) throws Exception;
}
