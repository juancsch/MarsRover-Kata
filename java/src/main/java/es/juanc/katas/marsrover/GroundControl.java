package es.juanc.katas.marsrover;

import java.io.PrintStream;
import java.util.Scanner;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

public class GroundControl {

	public static void main(String[] args) {

		var rover = new MarsRover(0, 0, NORTH, World.of(COLUMNS, FILES));

		Scanner scanner = new Scanner(System.in);
		var commands = "";

		while (true) {
            paintWorldAnd(rover.location());

			System.out.print("Enter commands: ");
			commands = scanner.nextLine();

			rover.commands(commands.split(""));
        }
    }

    private static final PrintStream view = System.out;
	private static final int COLUMNS = 10;
	private static final int FILES = 10;

    private static void paintWorldAnd(Location location) {

    	view.println(location);

        for (int file = 0; file < FILES; file++) {
	        view.print("|");
            for (int colunm = 0; colunm < COLUMNS; colunm++) {
	            var pixel = roverAreThere(location.position, colunm, file) ? paintRover(location.facing) : " |";
            	view.print(pixel);
            }
	        view.println("");
        }
    }

    private static String paintRover(Direction direction) {
    	return Match(direction).of(
			    Case($(NORTH), "↑|"),
			    Case($(SOUTH), "↓|"),
			    Case($(WEST), "←|"),
			    Case($(EAST), "→|")
	    );
    }

    private static boolean roverAreThere(Point position, int column, int file) {
	    return column == position.x && file == position.y;
    }
}
