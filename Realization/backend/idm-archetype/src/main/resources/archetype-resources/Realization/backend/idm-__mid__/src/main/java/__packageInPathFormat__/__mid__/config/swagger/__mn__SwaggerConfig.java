#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${mid}.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ${czechIdMGroupId}.core.api.config.swagger.AbstractSwaggerConfig;
import ${czechIdMGroupId}.core.api.domain.ModuleDescriptor;
import ${package}.${mid}.${mn}ModuleDescriptor;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * ${mn} module swagger configuration
 *
 * @author ${author}
 */
@Configuration
@ConditionalOnProperty(prefix = "springfox.documentation.swagger", name = "enabled", matchIfMissing = true)
public class ${mn}SwaggerConfig extends AbstractSwaggerConfig {

	@Autowired private ${mn}ModuleDescriptor moduleDescriptor;

	@Override
	protected ModuleDescriptor getModuleDescriptor() {
		return moduleDescriptor;
	}

	@Bean
	public Docket ${mid}Api() {
		return api("${package}.rest");
	}
}
