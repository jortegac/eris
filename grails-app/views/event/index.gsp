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
		<li><g:link class="create" action="create" >New event</g:link></li>
	</ul>
</div>
<div class="body">
    <table>
        <tr>
            <td>User</td>
            <td>Appliance</td>
            <td>Activity level</td>
            <td>Energy consumption</td>
            <td>Time</td>           
            <td>Actions</td>     
        </tr>
        <g:each in="${eventInstanceList}" var="event">
        <tr>
            <td>${event.user.name }</td>
            <td>${event.appliance.name}</td>
            <td>${event.activityLevel}</td>
            <td>${event.energyConsumption}</td>
            <td>${event.time}</td>
            <td>
            		<g:link controller="event" action="show" id="${event.id}">Show</g:link>          		
					<g:link action="edit" id="${event.id}">Edit</g:link>
			</td>
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>