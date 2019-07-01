#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${mid};

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import ${czechIdMGroupId}.core.api.domain.PropertyModuleDescriptor;
import ${czechIdMGroupId}.core.api.domain.ResultCode;
import ${czechIdMGroupId}.core.notification.api.dto.NotificationConfigurationDto;
import ${czechIdMGroupId}.core.security.api.domain.GroupPermission;
import ${package}.${mid}.domain.${mn}GroupPermission;
import ${package}.${mid}.domain.${mn}ResultCode;

/**
 * ${mn} module descriptor
 *
 * @author ${author}
 */
@Component
@PropertySource("classpath:module-" + ${mn}ModuleDescriptor.MODULE_ID + ".properties")
@ConfigurationProperties(prefix = "module." + ${mn}ModuleDescriptor.MODULE_ID + ".build", ignoreUnknownFields = true, ignoreInvalidFields = true)
public class ${mn}ModuleDescriptor extends PropertyModuleDescriptor {

	public static final String MODULE_ID = "${mid}";

	@Override
	public String getId() {
		return MODULE_ID;
	}

	/**
	 * Enables links to swagger documention
	 */
	@Override
	public boolean isDocumentationAvailable() {
		return true;
	}

	@Override
	public List<NotificationConfigurationDto> getDefaultNotificationConfigurations() {
		List<NotificationConfigurationDto> configs = new ArrayList<>();
		return configs;
	}

	@Override
	public List<GroupPermission> getPermissions() {
		return Arrays.asList(${mn}GroupPermission.values());
	}

	@Override
	public List<ResultCode> getResultCodes() {
		return Arrays.asList(${mn}ResultCode.values());
	}
}
