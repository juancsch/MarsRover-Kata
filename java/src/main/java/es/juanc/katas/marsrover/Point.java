package es.juanc.katas.marsrover;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class Point {
	public final int x;
	public final int y;

	public Point addX() {
		return Point.of(x + 1, y);
	}

	public Point addY() {
		return Point.of(x, y + 1);
	}

	public Point lessX() {
		return Point.of(x - 1, y);
	}

	public Point lessY() {
		return Point.of(x, y - 1);
	}
}
