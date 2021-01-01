package es.juanc.katas.marsrover;

import static es.juanc.katas.marsrover.Direction.*;

public enum Command {

	FORWARD {
		public Location executeOn(Location location) {

			if (location.facing == EAST) {
				return location.forwardX();
			}

			if (location.facing == NORTH) {
				return location.forwardY();
			}

			if (location.facing == WEST) {
				return location.backwardX();
			}

			if (location.facing == SOUTH) {
				return location.backwardY();
			}

			throw new IllegalStateException("Unknown facing location: " + location.facing);
		}
	},
	BACKWARD {
		public Location executeOn(Location location) {

			if (location.facing == EAST) {
				return location.backwardX();
			}

			if (location.facing == NORTH) {
				return location.backwardY();
			}

			if (location.facing == WEST) {
				return location.forwardX();
			}

			if (location.facing == SOUTH) {
				return location.forwardY();
			}

			throw new IllegalStateException("Unknown facing location: " + location.facing);
		}
	};

	public static Command of(String key) {
		if ("F".equalsIgnoreCase(key)) return FORWARD;
		if ("B".equalsIgnoreCase(key)) return BACKWARD;
		throw new IllegalArgumentException("Unknown command key: " + key);
	}

	public abstract Location executeOn(Location location);
}
