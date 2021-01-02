package es.juanc.katas.marsrover;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.With;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;

@With
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

	public final Point position;
	public final Direction facing;

	public Location forward() {

		if (facing == EAST) {
			return withPosition(position.addX());
		}

		if (facing == NORTH) {
			return withPosition(position.addY());
		}

		if (facing == WEST) {
			return withPosition(position.lessX());
		}

		if (facing == SOUTH) {
			return withPosition(position.lessY());
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	public Location backward() {

		if (facing == EAST) {
			return withPosition(position.lessX());
		}

		if (facing == NORTH) {
			return withPosition(position.lessY());
		}

		if (facing == WEST) {
			return withPosition(position.addX());
		}

		if (facing == SOUTH) {
			return withPosition(position.addY());
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	public Location right() {

		if (facing == EAST) {
			return withFacing(SOUTH);
		}

		if (facing == NORTH) {
			return withFacing(EAST);
		}

		if (facing == WEST) {
			return withFacing(NORTH);
		}

		if (facing == SOUTH) {
			return withFacing(WEST);
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	public Location left() {

		if (facing == EAST) {
			return withFacing(NORTH);
		}

		if (facing == NORTH) {
			return withFacing(WEST);
		}

		if (facing == WEST) {
			return withFacing(SOUTH);
		}

		if (facing == SOUTH) {
			return withFacing(EAST);
		}

		throw new IllegalStateException("Unknown facing location: " + facing);
	}

	public static Location of(int x, int y, Direction direction) {
		return new Location(Point.of(x, y), direction);
	}
}
