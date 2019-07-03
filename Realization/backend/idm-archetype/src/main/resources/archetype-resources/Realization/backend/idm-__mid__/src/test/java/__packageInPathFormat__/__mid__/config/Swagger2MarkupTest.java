#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${groupId}.${mid}.config;

import org.junit.Test;

import ${package}.${mid}.${mn}ModuleDescriptor;
import ${czechIdMGroupId}.test.api.AbstractSwaggerTest;


/**
 * Static swagger generation to sources - will be used as input for swagger2Markup build
 *
 * @author ${author}
 *
 */
public class Swagger2MarkupTest extends AbstractSwaggerTest {

	@Test
	public void testConvertSwagger() throws Exception {
		super.convertSwagger(${mn}ModuleDescriptor.MODULE_ID);
	}

}
