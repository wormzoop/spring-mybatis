package com.zoop.entity;

public class ResponseObject {

	private String code;
	
	private String message;
	
	private Object body;
	
	public ResponseObject(){
		super();
	}
	
	public ResponseObject(String code, String message, Object body){
		this.code = code;
		this.message = message;
		this.body = body;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
}
