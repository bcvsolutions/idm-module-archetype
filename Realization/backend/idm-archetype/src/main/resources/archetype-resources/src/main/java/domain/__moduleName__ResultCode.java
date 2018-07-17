#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $moduleNameLower = ${moduleName.toLowerCase()} )
package ${package}.domain;

import org.springframework.http.HttpStatus;

import ${groupId}.core.api.domain.ResultCode;

/**
 * Enum class for formatting response messages (mainly errors). 
 * Every enum contains a string message and corresponding https HttpStatus code.
 * 
 * Used http codes:
 * - 2xx - success
 * - 4xx - client errors (validations, conflicts ...)
 * - 5xx - server errors
 * 
 * @author ${author}
 */
public enum ${moduleName}ResultCode implements ResultCode {
	
	${moduleName.toUpperCase()}_CLIENT_ERROR(HttpStatus.BAD_REQUEST, "Example generated error [%s]");
	
	private final HttpStatus status;
	private final String message;
	
	private ${moduleName}ResultCode(HttpStatus status, String message) {
		this.message = message;
		this.status = status;
	}
	
	public String getCode() {
		return this.name();
	}
	
	public String getModule() {
		return "${moduleNameLower}";
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}	
}
