<%@page import="com.jon.entities.MessageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>chat web application</title>
<script type="text/javascript" src="ajaxFunctions.js" charset="UTF-8"></script>
<script type="text/javascript">
	function pullMessages(){
		makePullRequest();
		setTimeout(pullMessages, 2500);
	}
	function logout(){
		stopPullingMessages();
		var element = document.createElement("input");
	    element.setAttribute("type", "hidden");
	    element.setAttribute("name", "logout");
	    element.setAttribute("value", "true");
	    var chatServletForm = document.getElementById("chatServletForm");
	    chatServletForm.appendChild(element);
	    chatServletForm.submit();
	}
</script>
<style type="text/css">
	<%@ include file="Style.css" %>
</style>
</head>
<body onload="pullMessages()">
<div id="mainDiv">
<form action="ChatServlet" method="post" id="chatServletForm">
    <div class="formRow">
  		<div class="formCell">
			Message:
        </div>
     </div>
    <div class="formRow">
        <div class="formCell">
        <input type="text" name="rawMessage" class="inputWide"/>
        </div>
	</div>        
<div class="formRow">
  <div class="formCell">
		 Chat Messages:
	</div>
</div>    
		<textarea rows="10" cols="20" name="chatMessages" id="chatMessages" class="inputWide"></textarea>
<div class="formRow">
  <div class="formCell">        
		<input type="button" value="send" onclick="makeRequest()" class="buttonWide"/>
  </div>
</div>  
<div class="formRow">
  <div class="formCell">        
		<input type="button" value="log out" onclick="logout()" class="buttonWide"/>
	</div>
    </div>
</form>
</div>
</body>
</html>