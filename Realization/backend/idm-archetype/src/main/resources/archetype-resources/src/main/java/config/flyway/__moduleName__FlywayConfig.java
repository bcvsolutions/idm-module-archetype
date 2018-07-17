#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

import ${groupId}.core.api.config.flyway.AbstractFlywayConfiguration;
import ${groupId}.core.api.config.flyway.IdmFlywayAutoConfiguration;

/**
 * DB migration for ${moduleName} module
 * 
 * @author ${author}
 */
@Configuration
@ConditionalOnClass(Flyway.class)
@ConditionalOnProperty(prefix = "flyway", name = "enabled", matchIfMissing = false)
@AutoConfigureAfter(IdmFlywayAutoConfiguration.IdmFlywayConfiguration.class)
@EnableConfigurationProperties(FlywayProperties.class)
@PropertySource("classpath:/flyway-${moduleName.toLowerCase()}.properties")
public class ${moduleName}FlywayConfig extends AbstractFlywayConfiguration {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(${moduleName}FlywayConfig.class);

	@Bean
	@DependsOn("flywayCore")
	@ConditionalOnMissingBean(name = "flywayModule${moduleName}")
	@ConditionalOnExpression("${symbol_dollar}{flyway.enabled:true} && '${symbol_dollar}{flyway.example.locations}'!=''")
	@ConfigurationProperties(prefix = "flyway.${moduleName.toLowerCase()}")
	public Flyway flywayModuleExample() {
		Flyway flyway = super.createFlyway();		
		log.info("Starting flyway migration for ${moduleName.toLowerCase()} module [{}]: ", flyway.getTable());
		return flyway;
	}
}
