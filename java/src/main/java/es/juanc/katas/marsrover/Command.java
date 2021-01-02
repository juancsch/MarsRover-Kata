package es.juanc.katas.marsrover;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;

public enum Command {

	FORWARD {
		public Location executeOn(Location location) {

			if (location.facing == EAST) {
				return location.withPosition(location.position.addX());
			}

			if (location.facing == NORTH) {
				return location.withPosition(location.position.addY());
			}

			if (location.facing == WEST) {
				return location.withPosition(location.position.lessX());
			}

			if (location.facing == SOUTH) {
				return location.withPosition(location.position.lessY());
			}

			throw new IllegalStateException("Unknown facing location: " + location.facing);
		}
	},
	BACKWARD {
		public Location executeOn(Location location) {

			if (location.facing == EAST) {
				return location.withPosition(location.position.lessX());
			}

			if (location.facing == NORTH) {
				return location.withPosition(location.position.lessY());
			}

			if (location.facing == WEST) {
				return location.withPosition(location.position.addX());
			}

			if (location.facing == SOUTH) {
				return location.withPosition(location.position.addY());
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
