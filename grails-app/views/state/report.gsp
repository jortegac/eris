<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
    <title>State's report</title>
</head>
<body>
<div class="nav" role="navigation">
	<ul>
		<li><a class="home" href="${createLink(uri: "/", absolute: true)}">Home</a></li>
		<li><g:link class="create" action="create" >New event</g:link></li>
	</ul>
</div>
<div class="body">

<h1>Beliefs about ${user.name}'s engagement state </h1> 
<br/>

<gvisualization:lineCoreChart elementId="chart" title="Beliefs about human state in time" width="${960}" height="${480}" columns="${columnNames}" data="${statesChartData}" trendlines="${new Expando(5:new Expando([color: 'black', labelInLegend: 'Engagement trend', visibleInLegend: true, type: 'exponential']))}" />
<div id="chart"></div>	

	<br/>
	<center>
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
        <g:each in="${states}" var="state">
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