package es.juanc.katas.marsrover;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.With;

@With
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(staticName = "of")
public class Location {
	public final Point position;
	public final Direction facing;
}
