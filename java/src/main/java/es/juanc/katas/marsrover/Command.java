package es.juanc.katas.marsrover;

public enum Command {

	FORWARD {
		public Location executeOn(Location location, World world) {
			var nextPosition = location.facing.forward(location.position, world);
			world.checkObstacleIn(nextPosition);
			return location.withPosition(nextPosition);
		}
	},
	BACKWARD {
		public Location executeOn(Location location, World world) {
			var nextPosition = location.facing.backward(location.position, world);
			world.checkObstacleIn(nextPosition);
			return location.withPosition(nextPosition);
		}
	},
	RIGHT {
		public Location executeOn(Location location, World world) {
			return location.withFacing(location.facing.right());
		}
	},
	LEFT {
		public Location executeOn(Location location, World world) {
			return location.withFacing(location.facing.left());
		}
	};

	public static Command of(String key) {
		if ("F".equalsIgnoreCase(key)) return FORWARD;
		if ("B".equalsIgnoreCase(key)) return BACKWARD;
		if ("R".equalsIgnoreCase(key)) return RIGHT;
		if ("L".equalsIgnoreCase(key)) return LEFT;
		throw new IllegalArgumentException("Unknown command key: " + key);
	}

	public abstract Location executeOn(Location location, World world);
}
