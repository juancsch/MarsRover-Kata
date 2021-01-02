package es.juanc.katas.marsrover;

public enum Command {

	FORWARD {
		public Location executeOn(Location location) {
			return location.forward();
		}
	},
	BACKWARD {
		public Location executeOn(Location location) {
			return location.backward();
		}
	};

	public static Command of(String key) {
		if ("F".equalsIgnoreCase(key)) return FORWARD;
		if ("B".equalsIgnoreCase(key)) return BACKWARD;
		throw new IllegalArgumentException("Unknown command key: " + key);
	}

	public abstract Location executeOn(Location location);
}
