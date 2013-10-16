package eris

import grails.transaction.Transactional

class StateService {
	
	def static takeAdvice(User user, Integer adviceType){
		
		def lastState = State.findAllByUser(user, [sort:"dateCreated", order:"desc"])[0]
		
		def tmp = ['1':0, '2':0, '3':0, '4':0, '5':0, '6':0]
		
		tmp[adviceType.toString()] = 1
		
		def newEngagement = lastState.engagement + 0.1 * tmp['1']
		
		def newEnergyCost = lastState.energyCost + 0.1 * tmp['2']
		
		def newActivityLevel = lastState.activityLevel + 0.1 * tmp['3']
		
		def newSatisfaction = lastState.satisfaction + 0.1 * tmp['4']
		
		def newAttitude = lastState.attitude + 0.1 * tmp['5']
		
		def newIntention = lastState.intention + 0.1 * tmp['6']
		
		new State(user:user, energyCost:newEnergyCost, activityLevel:newActivityLevel, satisfaction:newSatisfaction, attitude:newAttitude, intention:newIntention, engagement:newEngagement).save()	
	}
}
