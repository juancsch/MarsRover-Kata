package es.juanc.katas.marsrover;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.With;

@With
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class Point {

	private static final int STEP_UNIT = 1;

	public final int x;
	public final int y;

	public Point addX(int lim) {
		return withX(inLimits(x + STEP_UNIT, lim));
	}

	public Point lessX(int lim) {
		return withX(inLimits(x - STEP_UNIT, lim));
	}

	public Point addY(int lim) {
		return withY(inLimits(y + STEP_UNIT, lim));
	}

	public Point lessY(int lim) {
		return withY(inLimits(y - STEP_UNIT, lim));
	}

	private int inLimits(int pos, int lim) {
		if (pos == lim) return 0;
		if (pos >= 0 && pos < lim) return pos;
		int rest = pos % lim;
		return rest > 0 ? lim - rest : lim + rest;
	}
}
