package eris

import grails.transaction.Transactional

class StateService {
	
	def static takeAdvice(User user, Integer adviceType){
		
		def lastState = State.findAllByUser(user, [sort:"dateCreated", order:"desc"])[0]
		
		def tmp = ['1':0, '2':0, '3':0, '4':0, '5':0, '6':0]
		
		tmp[adviceType.toString()] = 1
		
		def newEngagement = lastState.engagement + 0.1 * tmp['1']
		
		def newEnergyCost = lastState.energyCost - 0.1 * tmp['2']
		
		def newActivityLevel = lastState.activityLevel - 0.1 * tmp['3']
		
		def newSatisfaction = lastState.satisfaction + 0.1 * tmp['4']
		
		def newAttitude = lastState.attitude + 0.1 * tmp['5']
		
		def newIntention = lastState.intention + 0.1 * tmp['6']
		
		new State(user:user, energyCost:newEnergyCost.round(3), activityLevel:newActivityLevel.round(3), satisfaction:newSatisfaction.round(3), attitude:newAttitude.round(3), intention:newIntention.round(3), engagement:newEngagement.round(3)).save()	
	}
	
	def getMaxCo(User user){
		def appliances = Appliance.findAllByUser(user)
			
		def list_events = []
		for (app in appliances) {
			def tmp = Event.findAllByAppliance(app, [sort:"time", order:"desc"])[0]
			if (tmp != null){
				list_events.add(tmp)
			}
		}
		
		def maxCo = list_events[0]
		
		if(list_events.size()!= 1){
			for (int i = 1; i < list_events.size()-1; i++) {
				if(maxCo.appliance.energyConsumption > list_events[i].appliance.energyConsumption) {
					maxCo = list_events[i]
				}
			}			
		}		
		
		def name = maxCo.appliance.name
		
		return maxCo
	}
	
	def static takeAllAdvice(User user) {
		
		def advices = Advice.findAllByUserAndIsTaken(user, false)
		
		for(advice in advices){
			advice.isTaken = true
			advice.save()
		}
	}
}
