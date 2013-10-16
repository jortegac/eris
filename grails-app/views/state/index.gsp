<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>Events</title>
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
            <td>Energy cost</td>
			<td>Activity level</td>
			<td>Satisfaction</td>
			<td>Attitude</td>
			<td>Intention</td>
			<td>Engagement</td>
            <td>Date created</td>
        </tr>
        <g:each in="${stateInstanceList}" var="state">
        <tr>
            <td><g:link action="show" id="${state.user.id}">${state.user.name}</g:link></td>
            <td>${state.energyCost}</td>
			<td>${state.activityLevel}</td>			
            <td>${state.satisfaction}</td>
			<td>${state.attitude}</td>
			<td>${state.intention}</td>
			<td>${state.engagement}</td>
			<td>${state.dateCreated}</td>
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>