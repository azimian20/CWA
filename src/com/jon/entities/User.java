package com.jon.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User {

	private String userName;
	private String password;
	private List<MessageItem> translatedMessages = new ArrayList<MessageItem>();
	private String language;

	public User() {
		super();
		this.translatedMessages = new ArrayList<MessageItem>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<MessageItem> getTranslatedMessages() {
		return translatedMessages;
	}

	public void setTranslatedMessages(List<MessageItem> translatedMessages) {
		this.translatedMessages = translatedMessages;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
