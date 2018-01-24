function getXMLHttpRequest() {
	var xmlHttpReq;
	if (window.XMLHttpRequest) {
		xmlHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		try {
			xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (exp1) {
			try {
				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (exp2) {
				alert("Exception in getXMLHttpRequest()!");
			}
		}
	}
	return xmlHttpReq;
}

var pullingMessagesAllowed = true;
function stopPullingMessages() {
	pullingMessagesAllowed = false;
}
function resumePullingMessages() {
	pullingMessagesAllowed = true;
}
function makeRequest() {
	var xmlHttpRequest = getXMLHttpRequest();
	xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest);
	var rawMessage = document.getElementsByName("rawMessage")[0].value;
	document.getElementsByName("rawMessage")[0].value=""; 
	// --URL Parameters:
	var urlParameters = "?";
	urlParameters = urlParameters + "rawMessage=" + rawMessage;
	xmlHttpRequest.open("POST", "TranslateServlet" + urlParameters, true); // --
	xmlHttpRequest.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttpRequest.send(null);
}

function makePullRequest() {
	if (pullingMessagesAllowed) {
		var xmlHttpRequest = getXMLHttpRequest();
		xmlHttpRequest.onreadystatechange = getReadyStateHandlerPullRequest(xmlHttpRequest);
		xmlHttpRequest.open("POST", "ServerSentMessageEventServlet", true);
		xmlHttpRequest.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8");
		xmlHttpRequest.send(null);
	}
}
function getReadyStateHandler(xmlHttpRequest) {
	return function() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
			} else {
				alert("Http error " + xmlHttpRequest.status + ":"
						+ xmlHttpRequest.statusText);
			}
		}
	};
}
function getReadyStateHandlerPullRequest(xmlHttpRequest) {
	return function() {
		if (xmlHttpRequest.readyState == 4) {
			if (xmlHttpRequest.status == 200) {
				document.getElementById("chatMessages").value = xmlHttpRequest.responseText;
			} else {
				alert("Http error " + xmlHttpRequest.status + ":"
						+ xmlHttpRequest.statusText);
			}
		}
	};
}