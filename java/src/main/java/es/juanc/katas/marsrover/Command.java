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
	},
	RIGHT {
		public Location executeOn(Location location) {
			return location.right();
		}
	},
	LEFT {
		public Location executeOn(Location location) {
			return location.left();
		}
	};

	public static Command of(String key) {
		if ("F".equalsIgnoreCase(key)) return FORWARD;
		if ("B".equalsIgnoreCase(key)) return BACKWARD;
		if ("R".equalsIgnoreCase(key)) return RIGHT;
		if ("L".equalsIgnoreCase(key)) return LEFT;
		throw new IllegalArgumentException("Unknown command key: " + key);
	}

	public abstract Location executeOn(Location location);
}
