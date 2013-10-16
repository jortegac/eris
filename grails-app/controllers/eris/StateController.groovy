package eris

class StateController {

	static scaffold = true

    def index() { 
		if (!params.id) {
			[stateInstanceList: State.list()]
		}else {
			
			def results = State.findAllByUser(User.get(params.id))
			
			[stateInstanceList: results]
		}
	}
	
	def report() {
		
		def u = User.get(params.id)

		def states = State.findAllByUser(u, [sort:"dateCreated", order:"asc"])
		
		def counter = 0
		
		def statesChartData = []
		for (state in states) {
			def number = counter
			def energyCost = state.energyCost
			def activityLevel = state.activityLevel
			def satisfaction = state.satisfaction
			def attitude = state.attitude
			def intention = state.intention
			def engagement = state.engagement
			
			statesChartData.add([number, energyCost, activityLevel, satisfaction, attitude, intention, engagement])
			counter++
		}
		
		def columnNames = [['number', 'State'], ['number', 'Energy Cost'], ['number', 'Activity Level'], ['number', 'Satisfaction'], ['number', 'Attitude'], ['number', 'Intention'], ['number', 'Engagement'] ]
				
		[states: states, user: u, columnNames: columnNames, statesChartData:statesChartData ]
	}
}
