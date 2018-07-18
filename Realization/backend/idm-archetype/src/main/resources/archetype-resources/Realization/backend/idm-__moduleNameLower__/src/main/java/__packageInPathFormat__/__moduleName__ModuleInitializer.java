#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $moduleNameLower = "${moduleName.toLowerCase()}" )
package ${package};

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Initialize ${moduleNameLower} module
 * 
 * @author ${author}
 *
 */
@Component
@DependsOn("initApplicationData")
public class ${moduleName}ModuleInitializer implements ApplicationListener<ContextRefreshedEvent> {
 
	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(${moduleName}ModuleInitializer.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOG.info("Module [{}] initialization", ${moduleName}ModuleDescriptor.MODULE_ID);
	}
}