package eris

class AdviceController {

	static scaffold = true

    def index() { 
		if (!params.id) {
			[adviceInstanceList: Advice.list()]
		}else {
			
			def results = Advice.findAllByUser(User.get(params.id))
			
			[adviceInstanceList: results]
		}
	}
	
	def takeAdvice() {
		def advice = Advice.get(params.id)
		advice.isTaken = true
		advice.save()
		redirect(action: "index")
	}
}
