#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${mid};

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Initialize ${mn} module
 *
 * @author ${author}
 *
 */
@Component
@DependsOn("initApplicationData")
public class ${mn}ModuleInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(${mn}ModuleInitializer.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOG.info("Module [{}] initialization", ${mn}ModuleDescriptor.MODULE_ID);
	}
}
