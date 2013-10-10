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
}
