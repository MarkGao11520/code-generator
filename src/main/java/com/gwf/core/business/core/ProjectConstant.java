package com.gwf.core.business.core;

/**
 * 项目常量
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "";//项目基础包名称，根据自己公司的项目修改

    public static final String MODEL_PACKAGE = "com.gwf.core.business.**.model";//Model所在包
    public static final String MAPPER_PACKAGE = "com.gwf.core.business.**.dao";//Mapper所在包
    public static final String SERVICE_PACKAGE = "com.gwf.core.business.**.service";//Service所在包
    public static final String SERVICE_IMPL_PACKAGE = "com.gwf.core.business.**.impl";//ServiceImpl所在包
    public static final String CONTROLLER_PACKAGE =  "com.gwf.core.business.**.controller";//Controller所在包

    public static final String MAPPER_INTERFACE_REFERENCE = "com.gwf.core.business.core.Mapper";//Mapper插件基础接口的完全限定名
}
