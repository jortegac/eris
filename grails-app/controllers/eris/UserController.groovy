package eris

class UserController {

	static scaffold = true

    def index() { 
		
		[userInstanceList: User.list()]
	}
}
