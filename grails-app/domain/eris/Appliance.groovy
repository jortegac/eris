package eris

class Appliance {

	static belongsTo = [user: User]
	ApplianceType applianceType
	
	String name
	Date dateOfPurchase
	Double expectedConsumption

    static constraints = {
		name size: 5..45, blank: false
		expectedConsumption min: 0d, blank: false
    }
	
	String toString() {
		return name
	}
}
