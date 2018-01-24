package com.jon.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jon.TranslateText;
import com.jon.Util;
import com.jon.entities.MessageItem;
import com.jon.entities.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User jon = new User();
	User eric = new User();
	User ema = new User();
	TranslateText translateText = new TranslateText();
	Set<User> users = new HashSet<User>();

	public LoginServlet() {
		super();
		initUsers();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().isNew() || request.getSession(false) == null) {
			// --logged out and redirected here
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else { // --indirect/unauthorized access
			if (request.getSession(true).getAttribute("loginUser") == null) {
				// --logging in
				if (request.getParameter("userName") == null) {
					// --double check if its the login attempt
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					// -- login form is not submitted.
				} else {
					// --authorization
					String userName = request.getParameter("userName").toString();
					String password = request.getParameter("password").toString();
					String language = request.getParameter("language").toString();
					User user = authenticateUser(userName, password);
					if (user == null) {
						// --redirect error login message
						request.setAttribute("serverMessage", "Login Failed: User name or password is incorret!");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					} else {
						if (request.getSession(false).getServletContext().getAttribute("logins") == null) {
							request.getSession(false).getServletContext().setAttribute("logins", new HashSet<User>());
						}

						user.setLanguage(language);
						// --Translate all previously send messages to the user:
						ListIterator<MessageItem> _messageItems = Util.getSharedMessageData().getMessages()
								.listIterator();
						while (_messageItems.hasNext()) {
							MessageItem _messageItem = _messageItems.next();
							MessageItem _userMessageItem = new MessageItem();
							_userMessageItem.setLanguage(_messageItem.getLanguage());
							_userMessageItem.setOriginalMessageText(_messageItem.getOriginalMessageText());
							_userMessageItem.setSender(_messageItem.getSender());
							if (_messageItem.getLanguage().equals(user.getLanguage())) {
								_userMessageItem.setTranslatedMessageText(_messageItem.getOriginalMessageText());
							} else {
								_userMessageItem.setTranslatedMessageText(
										translateText.translate(_messageItem.getOriginalMessageText(),
												_messageItem.getLanguage(), user.getLanguage()));
							}
							user.getTranslatedMessages().add(_userMessageItem);
						}
						// --
						((Set<User>) request.getSession().getServletContext().getAttribute("logins")).add(user);
						request.getSession(false).setAttribute("loginUser", user);
						request.getRequestDispatcher("ChatServlet").forward(request, response);
					}
				}
			} else {
				// --user already logged in, going forward to
				// chat room
				request.getRequestDispatcher("ChatServlet").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void initUsers() { // --An imitation of dataBase users
		jon.setUserName("jon");
		jon.setPassword("123");
		eric.setUserName("eric");
		eric.setPassword("123");
		ema.setUserName("ema");
		ema.setPassword("123");
		users.add(jon);
		users.add(eric);
		users.add(ema);
	}

	private User authenticateUser(String userName, String password) {
		for (User user : users) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

}
