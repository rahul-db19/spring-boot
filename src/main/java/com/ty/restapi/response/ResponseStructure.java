package com.ty.restapi.response;

import org.springframework.http.HttpStatus;

public class ResponseStructure<T> {
	
	private T data;
	private HttpStatus httpStatus;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
