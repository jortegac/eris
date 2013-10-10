<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>Appliance Types</title>
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: "/", absolute: true)}">Home</a></li>
		<li><g:link class="create" action="create" >New appliance type</g:link></li>
	</ul>
</div>
<div class="body">

    <table>
        <tr>
            <td>Name</td>
            <td>Average consumption</td>
            <td>Actions</td>    
        </tr>
        <g:each in="${applianceTypeInstanceList}" var="applianceType">
        <tr>
            <td><g:link action="show" id="${applianceType.id}">${applianceType.name}</g:link></td>
            <td>${applianceType.averageConsumption}</td>
            <td><g:link action="edit" id="${applianceType.id}">Edit</g:link></td>                
        </tr>
        </g:each>        
    </table>
  </div>
</body>
</html>