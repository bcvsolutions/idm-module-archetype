#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${mid}.domain;

import org.springframework.http.HttpStatus;

import ${czechIdMGroupId}.core.api.domain.ResultCode;

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
public enum ${mn}ResultCode implements ResultCode {

	${mid.toUpperCase()}_CLIENT_ERROR(HttpStatus.BAD_REQUEST, "Example generated error [%s]");

	private final HttpStatus status;
	private final String message;

	private ${mn}ResultCode(HttpStatus status, String message) {
		this.message = message;
		this.status = status;
	}

	public String getCode() {
		return this.name();
	}
	
	public String getModule() {
		return "${mid}";
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
