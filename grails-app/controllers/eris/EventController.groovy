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
			println tmp.time
			eventList.add(tmp)	
			
		}
		
		def columnNamesAct = [['date', 'Time'], ['number', 'Activity level'] ]
		def columnNamesCon = [['date', 'Time'], ['number', 'Energy consumption'] ] 
				
		[userEventList: eventList, theuser: u, columnNamesAct: columnNamesAct, columnNamesCon: columnNamesCon ]
	}
}
