package eris

class State {
	
	User user
	Double energyCost
	Double activityLevel	
	Double satisfaction
	Double attitude
	Double intention
	Double engagement
	Date dateCreated
	
    static constraints = {
		user blank:false
		energyCost min: 0d, blank:false
		activityLevel min: 0d, blank:false		
		satisfaction min: 0d, blank:false
		attitude min: 0d, blank:false
		intention min: 0d, blank:false
		engagement min: 0d, blank:false
    }
	
	def afterInsert() {
		if (engagement < 0.5){
				
			new Advice(user:user, type:1, message:"Motivational message", isTaken:false).save()
		
			if(energyCost > 0.5){
				new Advice(user:user, type:2, message: " Using too much energy message", isTaken:false).save()
			}
			
			if(activityLevel > 0.5){
				new Advice(user:user, type:3, message: "Using too many times message", isTaken:false).save()
			}
			
			if(satisfaction < 0.5){
				new Advice(user:user, type:4, message:"Satisfaction help message", isTaken:false).save()
			}
			
			if(attitude < 0.5){
				new Advice(user:user, type:5, message:"Attitude help message", isTaken:false).save()
			}
			
			if(intention < 0.5){
				new Advice(user:user, type:6, message:"Intention help message", isTaken:false).save()
			}
		}
	}
	
}
