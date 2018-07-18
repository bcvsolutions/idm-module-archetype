#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $moduleNameLower = ${moduleName.toLowerCase()} )
package ${package}.${moduleName.toLowerCase()};

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
import ${package}.${moduleName.toLowerCase()}.domain.${moduleName}GroupPermission;
import ${package}.${moduleName.toLowerCase()}.domain.${moduleName}ResultCode;

/**
 * ${moduleName} module descriptor
 * 
 * @author ${author}
 */
@Component
@PropertySource("classpath:module-" + ${moduleName}ModuleDescriptor.MODULE_ID + ".properties")
@ConfigurationProperties(prefix = "module." + ${moduleName}ModuleDescriptor.MODULE_ID + ".build", ignoreUnknownFields = true, ignoreInvalidFields = true)
public class ${moduleName}ModuleDescriptor extends PropertyModuleDescriptor {

	public static final String MODULE_ID = "${moduleNameLower}";
	
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
		return Arrays.asList(${moduleName}GroupPermission.values());
	}

	@Override
	public List<ResultCode> getResultCodes() {
		return Arrays.asList(${moduleName}ResultCode.values());
	}
}
