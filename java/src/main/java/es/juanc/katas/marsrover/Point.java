package es.juanc.katas.marsrover;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class Point {

	private static final int STEP_UNIT = 1;

	public final int x;
	public final int y;

	public Point addX() {
		return Point.of(x + STEP_UNIT, y);
	}

	public Point addY() {
		return Point.of(x, y + STEP_UNIT);
	}

	public Point lessX() {
		return Point.of(x - STEP_UNIT, y);
	}

	public Point lessY() {
		return Point.of(x, y - STEP_UNIT);
	}
}
