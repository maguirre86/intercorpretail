package pe.com.intrecorpretail.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {

@JsonInclude(JsonInclude.Include.NON_NULL)
private String status;
@JsonInclude(JsonInclude.Include.NON_NULL)
private String message;
@JsonInclude(JsonInclude.Include.NON_NULL)
private Object data;

public Response(String status, String message, Object data) {
	super();
	this.status = status;
	this.message = message;
	this.data = data;
}

public Response() {
}

public Response(String message, Object data) {
	super();
	this.message = message;
	this.data = data;
}

public Response(String status) {
	super();
	this.status = status;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Object getData() {
	return data;
}

public void setData(Object data) {
	this.data = data;
}
}
