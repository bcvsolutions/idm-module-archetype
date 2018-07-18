#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${moduleName.toLowerCase()}.config.domain;

import org.springframework.stereotype.Component;

import ${czechIdMGroupId}.core.api.config.domain.AbstractConfiguration;

/**
 * ${moduleName} configuration - implementation
 * 
 * @author ${author}
 *
 */
@Component("${moduleName.toLowerCase()}Configuration")
public class Default${moduleName}Configuration 
		extends AbstractConfiguration
		implements ${moduleName}Configuration {
}
