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

<h1>${theuser}'s appliance usage history</h1>


<% def counter = 1 %>

<g:each in="${userEventList}" var="userEvent">

	<% def dataActivity = [] %>
	<% def dataConsumption = [] %>

	<h2>${userEvent.appliance.first()}</h2>
	<table>
		<tr>
			<td>Activity Level</td>
			<td>Energy Consumption</td>
			<td>Time</td>
		</tr>
		<g:each in="${userEvent}" var="event">  	
	    		
			<tr>
				<td>${event.activityLevel}</td>
				<td>${event.energyConsumption}</td>
				<td>${event.time}</td>
			</tr>
			
			<% dataActivity.add([event.time, event.activityLevel]) %>
			<% dataConsumption.add([event.time, event.energyConsumption]) %>			
	    
	    </g:each>
    </table>
	
	<gvisualization:lineCoreChart elementId="chart${counter}" width="${640}" height="${480}" columns="${columnNamesAct}" data="${dataActivity}"  />
	<div id="chart${counter}"></div>	
	<% counter++ %>
	
	<gvisualization:lineCoreChart elementId="chart${counter}" width="${640}" height="${480}" columns="${columnNamesCon}" data="${dataConsumption}"  />
	<div id="chart${counter}"></div>	
	<% counter++ %>
	
    </g:each>        
  </div>
</body>
</html>