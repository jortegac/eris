package eris

class Event {

	User user
	Appliance appliance
	Integer activityLevel
	Double energyConsumption
	Double runningTime
	Date time
	
    static constraints = {
		user blank: false
		appliance blank:false
		activityLevel blank: false, min: 0
		energyConsumption blank: false, min: 0d
		runningTime blank: false, min: 0d
		time blank:false
	}
	
	def afterInsert() {
		
		
		
		def lastState = State.findAllByUser(user, [sort:"dateCreated", order:"desc"])[0]
		
		def alpha = 0.8
		def beta = 1.0 - alpha
		def socialNormEnergy = appliance.applianceType.averageConsumption
		def socialNormUsage = appliance.applianceType.averageUsage
		
		def newEnergyCost = (alpha * lastState.energyCost) + beta*(energyConsumption/socialNormEnergy)
		
		def newSatisfaction = (alpha * lastState.satisfaction) + (beta * (0.4*(1-newEnergyCost) + (0.6*lastState.engagement)))
		
		def newActivityLevel = (alpha*lastState.activityLevel) + (beta*(activityLevel/socialNormUsage))
		
		def newAttitude = (alpha * lastState.attitude) + (beta * ((0.3*(1-(newActivityLevel) )) + (0.7*(1-newSatisfaction))))
		
		def newIntention = (alpha * lastState.intention) + (beta * ((0.8*newAttitude) + (0.2*(1-(energyConsumption/appliance.expectedConsumption)))))
		
		def newEngagement = (alpha * lastState.engagement) + (beta * ((newSatisfaction + newAttitude + (2*newIntention))/4))
		
		if(newEnergyCost<0d){
			newEnergyCost = 0d
		}
		
		if(newSatisfaction<0d){
			newSatisfaction = 0d
		}
		
		if(newActivityLevel<0){
			newActivityLevel = 0d
		}
		
		if(newAttitude<0d){
			newAttitude = 0d
		}
		
		if(newIntention<0d){
			newIntention = 0d
		}
		
		if(newEngagement<0d){
			newEngagement = 0d
		}
	
		def s = new State(user:user, energyCost:newEnergyCost.round(3), activityLevel:newActivityLevel.round(3), satisfaction:newSatisfaction.round(3), attitude:newAttitude.round(3), intention:newIntention.round(3), engagement:newEngagement.round(3))
		
		//println s
		
		if (!s.save()) {
			s.errors.each {
				println it
			}	
		}
		
	}
}

