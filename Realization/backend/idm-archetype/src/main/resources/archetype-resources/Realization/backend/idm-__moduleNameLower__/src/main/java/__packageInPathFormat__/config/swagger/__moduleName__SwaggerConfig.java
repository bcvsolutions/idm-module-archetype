#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ${groupId}.core.api.config.swagger.AbstractSwaggerConfig;
import ${groupId}.core.api.domain.ModuleDescriptor;
import ${package}.${moduleName}ModuleDescriptor;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * ${moduleName} module swagger configuration
 *
 * @author ${author}
 */
@Configuration
@ConditionalOnProperty(prefix = "springfox.documentation.swagger", name = "enabled", matchIfMissing = true)
public class ${moduleName}SwaggerConfig extends AbstractSwaggerConfig {

	@Autowired private ${moduleName}ModuleDescriptor moduleDescriptor;

	@Override
	protected ModuleDescriptor getModuleDescriptor() {
		return moduleDescriptor;
	}

	@Bean
	public Docket ${moduleName.toLowerCase()}Api() {
		return api("${package}.rest");
	}
}
