package es.juanc.katas.marsrover;

import io.vavr.collection.List;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;

public class MarsRover {

	private Point position;
	private Direction facing;
	private final World world;

	public MarsRover(int x, int y, Direction facing, World world) {
		this.position = Point.of(x, y);
		this.facing = facing;
		this.world = world;
	}

	public void commands(String... commands) {

		if (commands.length == 0) return;

		List.of(commands)
		    .map(String::toUpperCase)
		    .forEach(this::execute);
	}

	private void execute(String command) {
		switch (command) {
			case "F":
				position = forward();
				break;
			case "B":
				position = backward();
				break;
			case "R":
				facing = right();
				break;
			case "L":
				facing = left();
				break;
			default: throw new IllegalArgumentException(
					String.format("Unknown command key: %s", command)
			);
		}
	}

	private Point forward() {

		if (facing == EAST) {
			return position.forwardX(world.width);
		}

		if (facing == NORTH) {
			return position.forwardY(world.height);
		}

		if (facing == WEST) {
			return position.backwardX(world.width);
		}

		if (facing == SOUTH) {
			return position.backwardY(world.height);
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	private Point backward() {

		if (facing == EAST) {
			return position.backwardX(world.width);
		}

		if (facing == NORTH) {
			return position.backwardY(world.height);
		}

		if (facing == WEST) {
			return position.forwardX(world.width);
		}

		if (facing == SOUTH) {
			return position.forwardY(world.height);
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	private Direction right() {

		if (facing == EAST) {
			return SOUTH;
		}

		if (facing == NORTH) {
			return EAST;
		}

		if (facing == WEST) {
			return NORTH;
		}

		if (facing == SOUTH) {
			return WEST;
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	private Direction left() {

		if (facing == EAST) {
			return NORTH;
		}

		if (facing == NORTH) {
			return WEST;
		}

		if (facing == WEST) {
			return SOUTH;
		}

		if (facing == SOUTH) {
			return EAST;
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	public Location location() {
		return Location.of(position, facing);
	}
}
