package es.juanc.katas.marsrover;

import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor(staticName = "of")
public class World {
	public final int width;
	public final int height;
	public final List<Point> obstacles;

	public static World of(int width, int height) {
		return of(width, height, List.of());
	}
}
