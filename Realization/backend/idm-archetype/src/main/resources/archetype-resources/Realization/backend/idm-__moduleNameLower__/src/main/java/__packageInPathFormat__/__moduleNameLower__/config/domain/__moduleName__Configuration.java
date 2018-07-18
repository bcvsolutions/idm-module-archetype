#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${moduleName.toLowerCase()}.config.domain;

import java.util.ArrayList;
import java.util.List;

import ${czechIdMGroupId}.core.api.service.Configurable;

/**
 * ${moduleName} configuration - interface
 * 
 * @author ${author}
 */
public interface ${moduleName}Configuration extends Configurable {

	@Override
	default String getConfigurableType() {
		// please define your own configurable type there
		return "${moduleName.toLowerCase()}";
	}
	
	@Override
	default List<String> getPropertyNames() {
		List<String> properties = new ArrayList<>(); // we are not using superclass properties - enable and order does not make a sense here
		return properties;
	}
}
