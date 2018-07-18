#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${moduleName.toLowerCase()}.domain;

import java.util.Arrays;
import java.util.List;

import eu.bcvsolutions.idm.core.security.api.domain.BasePermission;
import eu.bcvsolutions.idm.core.security.api.domain.IdmBasePermission;
import ${czechIdMGroupId}.core.security.api.domain.GroupPermission;
import ${package}.${moduleName.toLowerCase()}.${moduleName}ModuleDescriptor;

/**
 * Aggregate base permission. Name can't contain character '_' - its used for joining to authority name.
 * 
 * @author ${author}
 *
 */
public enum ${moduleName}GroupPermission implements GroupPermission {
	
	/*
	 * Define your group permission there and example permission you can remove
	 */
	EXAMPLE${moduleName.toUpperCase()}(
			IdmBasePermission.ADMIN);

	public static final String EXAMPLE_${moduleName.toUpperCase()}_ADMIN = "EXAMPLE${moduleName.toUpperCase()}" + BasePermission.SEPARATOR + "ADMIN";

	private final List<BasePermission> permissions;
	
	private ${moduleName}GroupPermission(BasePermission... permissions) {
		this.permissions = Arrays.asList(permissions);
	}
	
	@Override
	public List<BasePermission> getPermissions() {		
		return permissions;
	}
	
	@Override
	public String getName() {
		return name();
	}	
	
	@Override
	public String getModule() {
		return ${moduleName}ModuleDescriptor.MODULE_ID;
	}
}
