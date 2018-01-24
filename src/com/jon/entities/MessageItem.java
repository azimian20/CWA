package com.jon.entities;

public class MessageItem {
	private User sender;
	private String originalMessageText;
	private String language;
	private String translatedMessageText;  //--Translated to user selected languages
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public String getOriginalMessageText() {
		return originalMessageText;
	}
	public void setOriginalMessageText(String originalMessageText) {
		this.originalMessageText = originalMessageText;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTranslatedMessageText() {
		return translatedMessageText;
	}
	public void setTranslatedMessageText(String translatedMessageText) {
		this.translatedMessageText = translatedMessageText;
	}
}
