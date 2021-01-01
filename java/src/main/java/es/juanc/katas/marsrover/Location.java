package es.juanc.katas.marsrover;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Location {

	public final Point position;
	public final Direction facing;

	public Location forwardX() {
		return new Location(
				position.addX(),
				facing
		);
	}

	public Location forwardY() {
		return new Location(
				position.addY(),
				facing
		);
	}

	public Location backwardX() {
		return new Location(
				position.lessX(),
				facing
		);
	}

	public Location backwardY() {
		return new Location(
				position.lessY(),
				facing
		);
	}

	public static Location of(int x, int y, Direction direction) {
		return new Location(Point.of(x, y), direction);
	}
}
