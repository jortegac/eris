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
		<li><g:link class="create" action="create" >New event</g:link></li>
	</ul>
</div>
<div class="body">

<h1>${theuser}'s appliance usage history</h1> 
<br/>

<% def counter = 1 %>

<g:each in="${userEventList}" var="userEvent">

	<% def dataActivity = [] %>
	<% def dataConsumption = [] %>

	<h2>${userEvent.appliance.first()}</h2> 
	<br/>
	<center>
	<table>
		<tr>
			<th>Times used</th>
			<th>Energy Consumption</th>
			<th>Time</th>
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
	
	
	<gvisualization:lineCoreChart elementId="chart${counter}" title="Usage in time" width="${960}" height="${480}" columns="${columnNamesAct}" data="${dataActivity}" trendlines="${new Expando(0:new Expando([color: 'orange', labelInLegend: 'Trend', visibleInLegend: true, type: 'exponential']))}"/>
	<div id="chart${counter}"></div>	
	<% counter++ %>
	
	<gvisualization:lineCoreChart elementId="chart${counter}" title="Consumption in time" width="${960}" height="${480}" columns="${columnNamesCon}" data="${dataConsumption}"  
	trendlines="${new Expando(0:new Expando([color: 'orange', labelInLegend: 'Trend', visibleInLegend: true, type: 'exponential']))}" />
	<div id="chart${counter}"></div>	
	<% counter++ %>
	</center>
	
    </g:each>        
  </div>
</body>
</html>