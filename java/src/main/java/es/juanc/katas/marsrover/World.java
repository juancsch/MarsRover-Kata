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

	public void checkObstacleIn(Point position) {
		if (obstacles.find(p -> p.x == position.x && p.y == position.y).isDefined()) {
			throw new ObstacleFoundException("There are a obstacle in: " + position);
		}
	}
}
