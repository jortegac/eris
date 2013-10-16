package eris

class Advice {

	User user
	Integer type
	String message
	Boolean isTaken
	Date dateCreated

    static constraints = {
		user blank: false
		type blank: false, min:1, max:6
		message size: 5..500, blank: false
		isTaken blank: false
    }
	
	def afterUpdate() {
		if(isTaken){
		
		
			StateService.takeAdvice(user, type)
		}
	}
}
