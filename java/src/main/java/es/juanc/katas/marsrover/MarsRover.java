package es.juanc.katas.marsrover;

public class MarsRover {

	private final Location location;

	public MarsRover(Location starLocation) {
		this.location = starLocation;
	}

	public void commands(String... commands) {
	}

	public Location location() {
		return location;
	}
}
