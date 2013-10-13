package eris

class EventController {
	
	static scaffold = true
	
    def index() { 
		
		if (!params.id) {
			[eventInstanceList: Event.list()]
		}else {
			
			def results = Event.withCriteria {
				user {
					eq("id", params.id.toLong())
				}
			}
			
			[eventInstanceList: results]
			
			//[eventInstanceList: Event.findAllWhere(Event.user : params.id)]
		}
	}
	
	def report() {
		
		def u = User.get(params.id)
		
		
		
		def appls = Appliance.withCriteria{
			user {
				eq("id", params.id.toLong())
			}
		}
			
		def eventList = []
		
		for (app in appls) {
			def events = Event.withCriteria {
				appliance {
					eq("id", app.id.toLong())
				}
			}
			eventList.add(events)
		}
		
		[userEventList: eventList, theuser: u]
	}
}
