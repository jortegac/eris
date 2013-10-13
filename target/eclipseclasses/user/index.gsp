<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>Users</title>
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: "/", absolute: true)}">Home</a></li>
		<li><g:link class="create" action="create" >New user</g:link></li>
	</ul>
</div>
<div class="body">
    <table>
        <tr>
            <td>Name</td>
            <td>Email</td>
            <td>Age</td>
            <td>Gender</td>
            <td>Appliances</td>
            <td>Date created</td>
            <td>Last updated</td>        
            <td>Actions</td>    
        </tr>
        <g:each in="${userInstanceList}" var="user">
        <tr>
            <td><g:link action="show" id="${user.id}">${user.name}</g:link></td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
            <td>
            	<g:each in="${user.appliances}" var="appliance">
            		<g:link controller="appliance" action="show" id="${appliance.id}">${appliance.name}</g:link>
            		<br/>
        		</g:each>
       		</td> 
            <td>${user.dateCreated}</td>
            <td>${user.lastUpdated}</td>
            <td>
            	<ul>
            		<li><g:link action="edit" id="${user.id}">Edit</g:link></li> 
            		<li><g:link controller="event" class="index" id="${user.id}">View events</g:link></li>
            		<li><g:link controller="event" class="create" id="${user.id}" action="create">New event</g:link></li>
            		
            	</ul>
           	</td>
                
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>