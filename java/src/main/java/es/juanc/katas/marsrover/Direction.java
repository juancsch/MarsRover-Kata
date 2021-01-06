package es.juanc.katas.marsrover;

public enum Direction {

	NORTH {
		public Point forward(Point position, World world) {
			return position.addY(world.height);
		}
		public Point backward(Point position, World world) {
			return position.lessY(world.height);
		}
		public Direction left() {
			return WEST;
		}
		public Direction right() {
			return EAST;
		}
	}, SOUTH {
		public Point forward(Point position, World world) {
			return position.lessY(world.height);
		}
		public Point backward(Point position, World world) {
			return position.addY(world.height);
		}
		public Direction left() {
			return EAST;
		}
		public Direction right() {
			return WEST;
		}
	}, EAST {
		public Point forward(Point position, World world) {
			return position.addX(world.width);
		}
		public Point backward(Point position, World world) {
			return position.lessX(world.width);
		}
		public Direction left() {
			return NORTH;
		}
		public Direction right() {
			return SOUTH;
		}
	}, WEST {
		public Point forward(Point position, World world) {
			return position.lessX(world.width);
		}
		public Point backward(Point position, World world) {
			return position.addX(world.width);
		}
		public Direction left() {
			return SOUTH;
		}
		public Direction right() {
			return NORTH;
		}
	};

	public abstract Point forward(Point location, World world);
	public abstract Point backward(Point location, World world);
	public abstract Direction right();
	public abstract Direction left();
}
