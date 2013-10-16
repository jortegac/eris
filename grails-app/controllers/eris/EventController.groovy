package eris

class EventController {
	
	static scaffold = true
	
    def index() { 
		
		if (!params.id) {
			[eventInstanceList: Event.list()]
		}else {
			
			def results = Event.findAllByUser(User.get(params.id))
			
			[eventInstanceList: results]
		}
	}
	
	def report() {
		
		def u = User.get(params.id)

		def appls = Appliance.findAllByUser(u)
		
		def eventList = []
		
		for (app in appls) {
			def tmp = Event.findAllByAppliance(app, [sort:"time", order:"asc"])
			eventList.add(tmp)	
			
		}
		
		def columnNamesAct = [['date', 'Time'], ['number', 'Times used'] ]
		def columnNamesCon = [['date', 'Time'], ['number', 'Energy consumption'] ] 
				
		[userEventList: eventList, theuser: u, columnNamesAct: columnNamesAct, columnNamesCon: columnNamesCon ]
	}
	
	def dummydata() {
		
		def user = User.get(3)
	
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 1590, runningTime: 120, time:Date.parse("yyyy-MM-dd", "2011-03-01")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 854, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2011-03-08")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1876, runningTime: 256, time:Date.parse("yyyy-MM-dd", "2011-03-15")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 928, runningTime: 128, time:Date.parse("yyyy-MM-dd", "2011-03-22")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2215, runningTime: 330, time:Date.parse("yyyy-MM-dd", "2011-03-29")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2310, runningTime: 395, time:Date.parse("yyyy-MM-dd", "2011-04-05")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2100, runningTime: 325, time:Date.parse("yyyy-MM-dd", "2011-04-12")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1347, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2011-04-19")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 906, runningTime: 154, time:Date.parse("yyyy-MM-dd", "2011-04-26")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1443, runningTime: 225, time:Date.parse("yyyy-MM-dd", "2011-05-03")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2455, runningTime: 380, time:Date.parse("yyyy-MM-dd", "2011-05-10")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 854, runningTime: 140, time:Date.parse("yyyy-MM-dd", "2011-05-17")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1290, runningTime: 204, time:Date.parse("yyyy-MM-dd", "2011-05-24")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1344, runningTime: 237, time:Date.parse("yyyy-MM-dd", "2011-05-31")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 800, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2011-06-07")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1704, runningTime: 240, time:Date.parse("yyyy-MM-dd", "2011-06-14")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1888, runningTime: 292, time:Date.parse("yyyy-MM-dd", "2011-06-21")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1449, runningTime: 231, time:Date.parse("yyyy-MM-dd", "2011-06-28")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 944, runningTime: 132, time:Date.parse("yyyy-MM-dd", "2011-07-05")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1215, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2011-07-12")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1860, runningTime: 260, time:Date.parse("yyyy-MM-dd", "2011-07-19")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1389, runningTime: 234, time:Date.parse("yyyy-MM-dd", "2011-07-26")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2375, runningTime: 340, time:Date.parse("yyyy-MM-dd", "2011-08-02")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 968, runningTime: 138, time:Date.parse("yyyy-MM-dd", "2011-08-09")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1700, runningTime: 320, time:Date.parse("yyyy-MM-dd", "2011-08-16")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1383, runningTime: 183, time:Date.parse("yyyy-MM-dd", "2011-08-23")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1395, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2011-08-30")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1648, runningTime: 248, time:Date.parse("yyyy-MM-dd", "2011-09-06")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1652, runningTime: 252, time:Date.parse("yyyy-MM-dd", "2011-09-13")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1299, runningTime: 192, time:Date.parse("yyyy-MM-dd", "2011-09-20")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2340, runningTime: 400, time:Date.parse("yyyy-MM-dd", "2011-09-27")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1368, runningTime: 186, time:Date.parse("yyyy-MM-dd", "2011-10-04")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2460, runningTime: 315, time:Date.parse("yyyy-MM-dd", "2011-10-11")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1952, runningTime: 296, time:Date.parse("yyyy-MM-dd", "2011-10-18")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 844, runningTime: 138, time:Date.parse("yyyy-MM-dd", "2011-10-25")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1824, runningTime: 312, time:Date.parse("yyyy-MM-dd", "2011-11-01")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2440, runningTime: 380, time:Date.parse("yyyy-MM-dd", "2011-11-08")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2090, runningTime: 340, time:Date.parse("yyyy-MM-dd", "2011-11-15")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 978, runningTime: 152, time:Date.parse("yyyy-MM-dd", "2011-11-22")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2020, runningTime: 335, time:Date.parse("yyyy-MM-dd", "2011-11-29")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1768, runningTime: 268, time:Date.parse("yyyy-MM-dd", "2011-12-06")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2280, runningTime: 395, time:Date.parse("yyyy-MM-dd", "2011-12-13")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 990, runningTime: 152, time:Date.parse("yyyy-MM-dd", "2011-12-20")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2370, runningTime: 320, time:Date.parse("yyyy-MM-dd", "2011-12-27")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1437, runningTime: 204, time:Date.parse("yyyy-MM-dd", "2012-01-03")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1888, runningTime: 304, time:Date.parse("yyyy-MM-dd", "2012-01-10")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2025, runningTime: 370, time:Date.parse("yyyy-MM-dd", "2012-01-17")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2455, runningTime: 345, time:Date.parse("yyyy-MM-dd", "2012-01-24")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2065, runningTime: 305, time:Date.parse("yyyy-MM-dd", "2012-01-31")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 900, runningTime: 140, time:Date.parse("yyyy-MM-dd", "2012-02-07")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1656, runningTime: 268, time:Date.parse("yyyy-MM-dd", "2012-02-14")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 940, runningTime: 130, time:Date.parse("yyyy-MM-dd", "2012-02-21")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 820, runningTime: 160, time:Date.parse("yyyy-MM-dd", "2012-02-28")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2105, runningTime: 350, time:Date.parse("yyyy-MM-dd", "2012-03-06")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 908, runningTime: 152, time:Date.parse("yyyy-MM-dd", "2012-03-13")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2375, runningTime: 335, time:Date.parse("yyyy-MM-dd", "2012-03-20")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2470, runningTime: 300, time:Date.parse("yyyy-MM-dd", "2012-03-27")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1756, runningTime: 316, time:Date.parse("yyyy-MM-dd", "2012-04-03")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 888, runningTime: 160, time:Date.parse("yyyy-MM-dd", "2012-04-10")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2100, runningTime: 310, time:Date.parse("yyyy-MM-dd", "2012-04-17")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 964, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2012-04-24")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1470, runningTime: 240, time:Date.parse("yyyy-MM-dd", "2012-05-01")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2225, runningTime: 375, time:Date.parse("yyyy-MM-dd", "2012-05-08")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 996, runningTime: 124, time:Date.parse("yyyy-MM-dd", "2012-05-15")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1203, runningTime: 234, time:Date.parse("yyyy-MM-dd", "2012-05-22")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2375, runningTime: 360, time:Date.parse("yyyy-MM-dd", "2012-05-29")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2150, runningTime: 315, time:Date.parse("yyyy-MM-dd", "2012-06-05")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2375, runningTime: 370, time:Date.parse("yyyy-MM-dd", "2012-06-12")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1470, runningTime: 210, time:Date.parse("yyyy-MM-dd", "2012-06-19")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 910, runningTime: 122, time:Date.parse("yyyy-MM-dd", "2012-06-26")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 2000, runningTime: 272, time:Date.parse("yyyy-MM-dd", "2012-07-03")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2460, runningTime: 330, time:Date.parse("yyyy-MM-dd", "2012-07-10")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 890, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2012-07-17")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2320, runningTime: 395, time:Date.parse("yyyy-MM-dd", "2012-07-24")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1296, runningTime: 216, time:Date.parse("yyyy-MM-dd", "2012-07-31")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1251, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2012-08-07")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1664, runningTime: 316, time:Date.parse("yyyy-MM-dd", "2012-08-14")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1218, runningTime: 189, time:Date.parse("yyyy-MM-dd", "2012-08-21")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1920, runningTime: 240, time:Date.parse("yyyy-MM-dd", "2012-08-28")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2080, runningTime: 305, time:Date.parse("yyyy-MM-dd", "2012-09-04")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 810, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2012-09-11")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1868, runningTime: 308, time:Date.parse("yyyy-MM-dd", "2012-09-18")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1952, runningTime: 320, time:Date.parse("yyyy-MM-dd", "2012-09-25")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:4, energyConsumption: 1716, runningTime: 300, time:Date.parse("yyyy-MM-dd", "2012-10-02")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2120, runningTime: 385, time:Date.parse("yyyy-MM-dd", "2012-10-09")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 890, runningTime: 142, time:Date.parse("yyyy-MM-dd", "2012-10-16")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1239, runningTime: 216, time:Date.parse("yyyy-MM-dd", "2012-10-23")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1660, runningTime: 312, time:Date.parse("yyyy-MM-dd", "2012-10-30")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1473, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2012-11-06")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2115, runningTime: 380, time:Date.parse("yyyy-MM-dd", "2012-11-13")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1696, runningTime: 260, time:Date.parse("yyyy-MM-dd", "2012-11-20")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1844, runningTime: 304, time:Date.parse("yyyy-MM-dd", "2012-11-27")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1341, runningTime: 234, time:Date.parse("yyyy-MM-dd", "2012-12-04")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2040, runningTime: 365, time:Date.parse("yyyy-MM-dd", "2012-12-11")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1796, runningTime: 320, time:Date.parse("yyyy-MM-dd", "2012-12-18")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2300, runningTime: 355, time:Date.parse("yyyy-MM-dd", "2012-12-25")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 944, runningTime: 154, time:Date.parse("yyyy-MM-dd", "2013-01-01")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1676, runningTime: 304, time:Date.parse("yyyy-MM-dd", "2013-01-08")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 986, runningTime: 156, time:Date.parse("yyyy-MM-dd", "2013-01-15")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1960, runningTime: 248, time:Date.parse("yyyy-MM-dd", "2013-01-22")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1992, runningTime: 312, time:Date.parse("yyyy-MM-dd", "2013-01-29")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:5, energyConsumption: 2300, runningTime: 310, time:Date.parse("yyyy-MM-dd", "2013-02-05")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1278, runningTime: 204, time:Date.parse("yyyy-MM-dd", "2013-02-12")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 972, runningTime: 144, time:Date.parse("yyyy-MM-dd", "2013-02-19")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2305, runningTime: 325, time:Date.parse("yyyy-MM-dd", "2013-02-26")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 824, runningTime: 124, time:Date.parse("yyyy-MM-dd", "2013-03-05")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 906, runningTime: 160, time:Date.parse("yyyy-MM-dd", "2013-03-12")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1422, runningTime: 201, time:Date.parse("yyyy-MM-dd", "2013-03-19")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 2000, runningTime: 248, time:Date.parse("yyyy-MM-dd", "2013-03-26")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1704, runningTime: 268, time:Date.parse("yyyy-MM-dd", "2013-04-02")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2005, runningTime: 310, time:Date.parse("yyyy-MM-dd", "2013-04-09")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1972, runningTime: 288, time:Date.parse("yyyy-MM-dd", "2013-04-16")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2005, runningTime: 310, time:Date.parse("yyyy-MM-dd", "2013-04-23")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 882, runningTime: 126, time:Date.parse("yyyy-MM-dd", "2013-04-30")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 822, runningTime: 160, time:Date.parse("yyyy-MM-dd", "2013-05-07")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1344, runningTime: 183, time:Date.parse("yyyy-MM-dd", "2013-05-14")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2095, runningTime: 385, time:Date.parse("yyyy-MM-dd", "2013-05-21")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1676, runningTime: 264, time:Date.parse("yyyy-MM-dd", "2013-05-28")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2490, runningTime: 360, time:Date.parse("yyyy-MM-dd", "2013-06-04")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1368, runningTime: 216, time:Date.parse("yyyy-MM-dd", "2013-06-11")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1368, runningTime: 186, time:Date.parse("yyyy-MM-dd", "2013-06-18")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1500, runningTime: 237, time:Date.parse("yyyy-MM-dd", "2013-06-25")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2050, runningTime: 345, time:Date.parse("yyyy-MM-dd", "2013-07-02")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:4, energyConsumption: 1612, runningTime: 316, time:Date.parse("yyyy-MM-dd", "2013-07-09")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:3, energyConsumption: 1386, runningTime: 240, time:Date.parse("yyyy-MM-dd", "2013-07-16")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:5, energyConsumption: 2435, runningTime: 370, time:Date.parse("yyyy-MM-dd", "2013-07-23")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:2, energyConsumption: 916, runningTime: 136, time:Date.parse("yyyy-MM-dd", "2013-07-30")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1236, runningTime: 207, time:Date.parse("yyyy-MM-dd", "2013-08-06")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:3, energyConsumption: 1269, runningTime: 183, time:Date.parse("yyyy-MM-dd", "2013-08-13")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 824, runningTime: 152, time:Date.parse("yyyy-MM-dd", "2013-08-20")).save()
		StateService.takeAllAdvice(user)
		new Event(user:user, appliance:Appliance.get(22), activityLevel:5, energyConsumption: 2050, runningTime: 325, time:Date.parse("yyyy-MM-dd", "2013-08-27")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1380, runningTime: 186, time:Date.parse("yyyy-MM-dd", "2013-09-03")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:3, energyConsumption: 1410, runningTime: 225, time:Date.parse("yyyy-MM-dd", "2013-09-10")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1852, runningTime: 276, time:Date.parse("yyyy-MM-dd", "2013-09-17")).save()
		new Event(user:user, appliance:Appliance.get(22), activityLevel:2, energyConsumption: 948, runningTime: 124, time:Date.parse("yyyy-MM-dd", "2013-09-24")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1920, runningTime: 252, time:Date.parse("yyyy-MM-dd", "2013-10-01")).save()
		new Event(user:user, appliance:Appliance.get(23), activityLevel:2, energyConsumption: 962, runningTime: 120, time:Date.parse("yyyy-MM-dd", "2013-10-08")).save()
		new Event(user:user, appliance:Appliance.get(21), activityLevel:4, energyConsumption: 1724, runningTime: 252, time:Date.parse("yyyy-MM-dd", "2013-10-15")).save()
		StateService.takeAllAdvice(user)
		
		redirect(action: "index")
	}
	

}
