package com.web_App_2.ApplicationDto;

import java.util.List;

import com.web_App_2.EntityClass.ApplicationData;

public class ExtraMessageOrArgsDto {

	public String Message;
	public ApplicationData readedAllDataSetter;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public ApplicationData getReadedAllDataSetter() {
		return readedAllDataSetter;
	}
	public void setReadedAllDataSetter(ApplicationData savedData) {
		this.readedAllDataSetter = savedData;
	}
	
}
