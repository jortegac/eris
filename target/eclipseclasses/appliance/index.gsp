<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>Appliances</title>
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: "/", absolute: true)}">Home</a></li>
		<li><g:link class="create" action="create" >New appliance</g:link></li>
	</ul>
</div>
<div class="body">
    <table>
        <tr>
            <td>Name</td>
            <td>Date of purchase</td>
            <td>Expected Weekly Consumption</td>
            <td>Owner</td>
            <td>Actions</td>    
        </tr>
        <g:each in="${applianceInstanceList}" var="appliance">
        <tr>
            <td><g:link action="show" id="${appliance.id}">${appliance.name}</g:link></td>
            <td>${appliance.dateOfPurchase}</td>
            <td>${appliance.expectedConsumption}</td>
            <td>           	
           		<g:link controller="user" action="show" id="${appliance.user.id}">${appliance.user.name}</g:link>
       		</td> 
            <td><g:link action="edit" id="${appliance.id}">Edit</g:link></td>                
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>