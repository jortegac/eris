package eris

class StateController {

	static scaffold = true

    def index() { 
		if (!params.id) {
			[stateInstanceList: State.list()]
		}else {
			
			def results = State.findAllByUser(User.get(params.id))
			
			[stateInstanceList: results]
		}
	}
	
	def takeAdvice() {
	

	}
}
