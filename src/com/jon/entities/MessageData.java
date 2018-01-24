package com.jon.entities;

import java.io.Serializable;
import java.util.List;

public class MessageData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<MessageItem> messages;
	
	public List<MessageItem> getMessages() {
		return messages;
	}
	public void setMessages(List<MessageItem> messages) {
		this.messages = messages;
	}
	
}
