package se.umejug.rest.jaxrs;

public class RestError {

	public enum ErrorCodes {
		INTERNAL_SERVER_ERROR, INVALID_JSON_INPUT
	}

	private String message;
	private ErrorCodes errorcode;

	public RestError(String message, ErrorCodes errorcode) {
		this.message = message;
		this.errorcode = errorcode;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorcode() {
		return errorcode.toString();
	}

	@Override
	public int hashCode() {
		return message.hashCode() + errorcode.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RestError))
			return false;
		RestError other = (RestError) obj;
		return message.equals(other.message) && errorcode.equals(other.errorcode);
	}

	@Override
	public String toString() {
		return message + "(" + errorcode + ")";
	}
}
