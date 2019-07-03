#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${mid}.domain;

import java.util.Arrays;
import java.util.List;

import eu.bcvsolutions.idm.core.security.api.domain.BasePermission;
import eu.bcvsolutions.idm.core.security.api.domain.IdmBasePermission;
import ${czechIdMGroupId}.core.security.api.domain.GroupPermission;
import ${package}.${mid}.${mn}ModuleDescriptor;

/**
 * Aggregate base permission. Name can't contain character '_' - its used for joining to authority name.
 *
 * @author ${author}
 *
 */
public enum ${mn}GroupPermission implements GroupPermission {

	/*
	 * Define your group permission there and example permission you can remove
	 */
	EXAMPLE${mid.toUpperCase()}(
			IdmBasePermission.ADMIN);

	public static final String EXAMPLE_${mid.toUpperCase()}_ADMIN = "EXAMPLE${mid.toUpperCase()}" + BasePermission.SEPARATOR + "ADMIN";

	private final List<BasePermission> permissions;

	private ${mn}GroupPermission(BasePermission... permissions) {
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
		return ${mn}ModuleDescriptor.MODULE_ID;
	}
}
