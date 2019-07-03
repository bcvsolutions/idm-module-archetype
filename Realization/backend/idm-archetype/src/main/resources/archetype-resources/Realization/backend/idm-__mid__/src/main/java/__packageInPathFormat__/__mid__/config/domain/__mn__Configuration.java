#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${mid}.config.domain;

import java.util.ArrayList;
import java.util.List;

import ${czechIdMGroupId}.core.api.service.Configurable;

/**
 * ${mn} configuration - interface
 *
 * @author ${author}
 */
public interface ${mn}Configuration extends Configurable {

	@Override
	default String getConfigurableType() {
		return "configuration";
	}

	@Override
	default List<String> getPropertyNames() {
		List<String> properties = new ArrayList<>(); // we are not using superclass properties - enable and order does not make a sense here
		return properties;
	}
}
