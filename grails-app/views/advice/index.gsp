<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>Advice</title>
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: "/", absolute: true)}">Home</a></li>
	</ul>
</div>
<div class="body">
    <table>
        <tr>
            <td>User</td>
            <td>Type</td>
            <td>Advice</td>
            <td>Taken?</td>
            <td>Date created</td>    
			<td>Actions</td>    
        </tr>
        <g:each in="${adviceInstanceList}" var="advice">
        <tr>
            <td><g:link controller="user" action="index" id="${advice.user.id}">${advice.user.name}</g:link></td>
            <td>${advice.type}</td>
			<td>${advice.message}</td>
            <td>${advice.isTaken}</td>
			<td>${advice.dateCreated}</td>
            <td>
				<%if (!advice.isTaken){%>
					<g:link action="takeAdvice" id="${advice.id}">Take advice</g:link>
				<%}%>
			</td>                
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>