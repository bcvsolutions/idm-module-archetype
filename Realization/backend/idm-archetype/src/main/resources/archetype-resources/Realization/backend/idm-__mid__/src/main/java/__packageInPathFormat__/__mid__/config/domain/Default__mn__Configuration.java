#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${groupId}.${mid}.config.domain;

import org.springframework.stereotype.Component;

import ${czechIdMGroupId}.core.api.config.domain.AbstractConfiguration;

/**
 * ${mn} configuration - implementation
 *
 * @author ${author}
 *
 */
@Component("${mid}Configuration")
public class Default${mn}Configuration
		extends AbstractConfiguration
		implements ${mn}Configuration {
}
