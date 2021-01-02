package es.juanc.katas.marsrover;

public enum Direction {
	NORTH {
		public Location forward(Location location) {
			return location.withPosition(location.position.addY());
		}
		public Location backward(Location location) {
			return location.withPosition(location.position.lessY());
		}
	}, SOUTH {
		public Location forward(Location location) {
			return location.withPosition(location.position.lessY());
		}
		public Location backward(Location location) {
			return location.withPosition(location.position.addY());
		}
	}, EAST {
		public Location forward(Location location) {
			return location.withPosition(location.position.addX());
		}
		public Location backward(Location location) {
			return location.withPosition(location.position.lessX());
		}
	}, WEST {
		public Location forward(Location location) {
			return location.withPosition(location.position.lessX());
		}
		public Location backward(Location location) {
			return location.withPosition(location.position.addX());
		}
	};

	public abstract Location forward(Location location);
	public abstract Location backward(Location location);
}
