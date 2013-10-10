package eris

class Event {
	
	
	User user
	Appliance appliance
	Integer activityLevel
	Double energyConsumption
	Date time
	
    static constraints = {
		user blank: false
		appliance blank:false
		activityLevel blank: false, min: 0
		energyConsumption blank: false, min: 0d
		time blank:false
    }
}
