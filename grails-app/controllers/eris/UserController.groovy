package eris

class UserController {

	static scaffold = true

    def index() { 
		
		[userInstanceList: User.list()]
	}
	
	def initState() {
		
		def lastUser
		
		if (!params.id) {
			lastUser = User.get(params:id.toLong())
		}else {
			lastUser = User.listOrderByDateCreated(max: 1, order: "desc")
		}
		new State(user:lastUser, activityLevel:0.5, energyCost:0.5, satisfaction:0.5, attitude:0.5, intention:0.5, engagement:0.5).save()
			
		redirect(action: "index")
	}
}
