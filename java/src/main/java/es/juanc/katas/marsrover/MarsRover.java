package es.juanc.katas.marsrover;

import io.vavr.collection.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MarsRover {

	private Location location;
	private final World world;

	public MarsRover(int x, int y, Direction facing, World world) {
		this.location = Location.of(Point.of(x, y), facing);
		this.world = world;
	}

	public void commands(String... commands) {

		if (commands.length == 0) return;

		try {
			location = List.of(commands)
				.map(Command::of)
				.foldLeft(location, (loc, cmd) -> cmd.executeOn(loc, world));
		} catch (ObstacleFoundException ofe) {
			log.info(ofe.getMessage());
		}
	}

	public Location location() {
		return location;
	}
}
