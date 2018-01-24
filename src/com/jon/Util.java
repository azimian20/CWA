package com.jon;

import java.util.ArrayList;

import com.jon.entities.MessageData;
import com.jon.entities.MessageItem;
import com.jon.entities.User;

public class Util {
	private static MessageData messageData;

	public static MessageData getSharedMessageData() {
		if (Util.messageData == null) {
			MessageData _messageData = new MessageData();
			_messageData.setMessages(new ArrayList<MessageItem>());
			Util.messageData = _messageData;
			return _messageData;
		} else {
			return Util.messageData;
		}
	}

	public static void appendToSharedMessageData(String rawMessage, String language,
			User user) {
		MessageItem _messageItem = new MessageItem();
		_messageItem.setLanguage(language);
		_messageItem.setSender(user);
		_messageItem.setTranslatedMessageText("");
		_messageItem.setOriginalMessageText(rawMessage);
		getSharedMessageData().getMessages().add(_messageItem);
	}

	public static void setSharedMessageData(MessageData messageData) {
		Util.messageData = messageData;
	}

}
