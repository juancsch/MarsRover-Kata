package es.juanc.katas.marsrover;

import java.io.PrintStream;
import java.util.Scanner;

import io.vavr.collection.List;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

public class GroundControl {

	public static void main(String[] args) {

		var obstacles = List.of(Point.of(5, 5));
		var rover = new MarsRover(0, 0, NORTH, World.of(COLUMNS, FILES, obstacles));

		Scanner scanner = new Scanner(System.in);
		var commands = "";

		while (true) {
            paintWorldAnd(rover.location(), obstacles);

			System.out.print("Enter commands: ");
			commands = scanner.nextLine();

			rover.commands(commands.split(""));
        }
    }

    private static final PrintStream view = System.out;
	private static final int COLUMNS = 10;
	private static final int FILES = 10;

    private static void paintWorldAnd(Location roverLocation, List<Point> obstacles) {

    	view.println(roverLocation);

        for (int file = 0; file < FILES; file++) {
	        view.print("|");
            for (int colunm = 0; colunm < COLUMNS; colunm++) {
	            view.print(
	            		roverAreThere(colunm, file, roverLocation.position) ?
		                        paintRover(roverLocation.facing) :
		                        paintCell(colunm, file, obstacles)
	            );
            }
	        view.println("");
        }
    }

	private static boolean roverAreThere(int column, int file, Point roverLoc) {
		return column == roverLoc.x && file == roverLoc.y;
	}

    private static String paintRover(Direction direction) {
    	return Match(direction).of(
			    Case($(NORTH), "↑|"),
			    Case($(SOUTH), "↓|"),
			    Case($(WEST), "←|"),
			    Case($(EAST), "→|")
	    );
    }

	private static String paintCell(int column, int file, List<Point> obstacles) {
		return obstacles.find(ob -> ob.x == column && ob.y == file).isDefined() ? "*|" : " |";
	}
}
