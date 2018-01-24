package com.jon.servlets;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jon.entities.MessageItem;
import com.jon.entities.User;

@WebServlet("/ServerSentMessageEventServlet")
public class ServerSentMessageEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServerSentMessageEventServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		User user = (User) request.getSession().getAttribute("loginUser");
		String translatedMessageText = "";
		// --create and decorate shared message
		List<MessageItem> _userTranslatedMessages = user.getTranslatedMessages();
		ListIterator<MessageItem> _userTranslatedMessagesIterator = _userTranslatedMessages.listIterator();
		while (_userTranslatedMessagesIterator.hasNext()) {
			MessageItem _userTranslatedMessageIterator = (MessageItem) _userTranslatedMessagesIterator.next();
			translatedMessageText = translatedMessageText
					.concat(decorateMessagesToShow(_userTranslatedMessageIterator.getSender().getUserName(),
							_userTranslatedMessageIterator.getTranslatedMessageText()));

		}

		response.setCharacterEncoding("UTF-8");
		translatedMessageText = translatedMessageText.replace("&#39;", "\'");
		response.getWriter().write(translatedMessageText);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String decorateMessagesToShow(String senderName, String senderMessage) {
		return senderName + ": " + senderMessage + "\n";
	}

}
