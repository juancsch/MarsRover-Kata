package es.juanc.katas.marsrover;

import io.vavr.collection.List;

public class MarsRover {

	private Location location;

	public MarsRover(Location starLocation) {
		this.location = starLocation;
	}

	public void commands(String... commands) {

		if (commands.length == 0) return;

		location = List.of(commands)
					   .map(Command::of)
					   .foldLeft(
					   		location,
							(loc, cmd) -> cmd.executeOn(loc)
					   );
	}

	public Location location() {
		return location;
	}
}
