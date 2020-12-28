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
	public static Location of(int x, int y, Direction direction) {
		return new Location(Point.of(x, y), direction);
	}
}
