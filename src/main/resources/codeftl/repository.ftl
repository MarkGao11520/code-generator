package ${basePackage}.dao;

import ${corePackage}.Mapper;
import ${basePackage}.entity.${table.entityName};
import org.springframework.stereotype.Repository;

/**
* Created with ${author} on ${.now}.
*/
@Repository
public interface ${table.entityName}Repository extends Mapper<${table.entityName}> {

}

