package eris

class ApplianceType {

	String name
	Double averageConsumption

    static constraints = {
		name size: 5..45, blank: false
		averageConsumption min: 0d, blank: false
    }
	
	String toString() {
		return name
	}
}
