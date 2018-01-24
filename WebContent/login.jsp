<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript">
function initPage(){
	<% if(request.getAttribute("serverMessage") != null) {%>
	alert('<%=request.getAttribute("serverMessage").toString()%>');
	document.getElementById('userName').value='';
	document.getElementById('password').value='';
	<% } %>
	}
</script>
<style type="text/css">
	<%@ include file="Style.css" %>
</style>

</head>
<body onload="initPage()">
<div id="mainDiv" class="mainDiv">
	<form action="LoginServlet" method="post">
		<div class="formRow">
  <div class="formCell">
  user name : 
  </div>
  <div class="formCell">
  <input type="text" name="userName" class="input"/>
  </div>
</div>
<div class="formRow">
  <div class="formCell">
      password:
  </div>
  <div class="formCell">
      <input type="password" name="password" class="input"/> 
  </div>
</div>
<div class="formRow">
  <div class="formCell">
        Language:
  </div> 
  <div class="formCell">
        <select name="language" class="input">
			<option value="en" selected>English</option>
			<option value="sq">Albanian</option>
			<option value="ar">Arabic</option>
			<option value="be">Belarusian</option>
			<option value="hr">Croatian</option>
			<option value="cs">Czech</option>
			<option value="da">Danish</option>
			<option value="nl">Dutch</option>
			<option value="et">Estonian</option>
			<option value="fi">Finnish</option>
			<option value="fr">French</option>
			<option value="fy">Frisian</option>
			<option value="de">German</option>
			<option value="el">Greek</option>
			<option value="iw">Hebrew</option>
			<option value="hi">Hindi</option>
			<option value="hu">Hungarian</option>
			<option value="is">Icelandic</option>
			<option value="ga">Irish</option>
			<option value="it">Italian</option>
			<option value="ja">Japanese</option>
			<option value="ko">Korean</option>
			<option value="la">Latin</option>
			<option value="lv">Latvian</option>
			<option value="lt">Lithuanian</option>
			<option value="no">Norwegian</option>
			<option value="fa">Persian</option>
			<option value="pl">Polish</option>
			<option value="pt">Portuguese</option>
			<option value="ro">Romanian</option>
			<option value="ru">Russian</option>
			<option value="sk">Slovak</option>
			<option value="sl">Slovenian</option>
			<option value="so">Somali</option>
			<option value="es">Spanish</option>
			<option value="sv">Swedish</option>
			<option value="th">Thai</option>
			<option value="tr">Turkish</option>
			<option value="uk">Ukrainian</option>
			<option value="ur">Urdu</option>
			<option value="cy">Welsh</option>
		</select> 
    </div>
</div>
<div class="formRow">
  <div class="formCell">
  </div>
  <div class="formCell">
        <input type="submit" name="submit" value="login" class="button"/>
  </div>
</div>
	</form>
</div>
</body>
</html>