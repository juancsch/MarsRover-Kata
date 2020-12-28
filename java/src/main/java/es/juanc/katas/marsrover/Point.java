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
}
