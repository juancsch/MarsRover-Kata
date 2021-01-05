package es.juanc.katas.marsrover;

import java.util.stream.Stream;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static es.juanc.katas.marsrover.Direction.EAST;
import static es.juanc.katas.marsrover.Direction.NORTH;
import static es.juanc.katas.marsrover.Direction.SOUTH;
import static es.juanc.katas.marsrover.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MarsRoverShould {

    @ParameterizedTest
    @MethodSource("starLocationCommandsAndExpectedLocation")
    void retrieve_actual_position_after_command_introduced(int x, int y, Direction facing,
                                                           String[] commands,
                                                           int xe, int ye, Direction fe) {
        // given
        var rover = new MarsRover(
                x, y, facing,
                World.of(10, 10)
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                Location.of(Point.of(xe, ye), fe)
        );
    }

    static Stream<Arguments> starLocationCommandsAndExpectedLocation() {
        return Stream.of(
                // without command
                arguments(0, 0, EAST, new String[] {}, 0, 0, EAST),
                // forward backward commands
                arguments(0, 0, EAST, new String[] {"F"}, 1, 0, EAST),
                arguments(0, 0, NORTH, new String[] {"f"}, 0, 1, NORTH),
                arguments(1, 1, WEST, new String[] {"F"}, 0, 1, WEST),
                arguments(1, 1, SOUTH, new String[] {"f"}, 1, 0, SOUTH),
                arguments(1, 1, EAST, new String[] {"B"}, 0, 1, EAST),
                arguments(1, 1, NORTH, new String[] {"b"}, 1, 0, NORTH),
                arguments(0, 0, WEST, new String[] {"B"}, 1, 0, WEST),
                arguments(0, 0, SOUTH, new String[] {"b"}, 0, 1, SOUTH),
                // several command
                arguments(1, 1, NORTH, new String[] {"b", "F", "f"}, 1, 2, NORTH),
                // right left commands
                arguments(1, 1, NORTH, new String[] {"l"}, 1, 1, WEST),
                arguments(1, 1, NORTH, new String[] {"R"}, 1, 1, EAST),
                arguments(1, 1, SOUTH, new String[] {"L"}, 1, 1, EAST),
                arguments(1, 1, SOUTH, new String[] {"r"}, 1, 1, WEST),
                arguments(1, 1, EAST, new String[] {"L"}, 1, 1, NORTH),
                arguments(1, 1, EAST, new String[] {"R"}, 1, 1, SOUTH),
                arguments(1, 1, WEST, new String[] {"l"}, 1, 1, SOUTH),
                arguments(1, 1, WEST, new String[] {"r"}, 1, 1, NORTH),
                // throughout the limits
                arguments(0, 0, NORTH, new String[] {"b"}, 0, 9, NORTH),
                arguments(0, 9, NORTH, new String[] {"f"}, 0, 0, NORTH),
                arguments(0, 0, EAST, new String[] {"b"}, 9, 0, EAST),
                arguments(9, 0, EAST, new String[] {"f"}, 0, 0, EAST),
                arguments(0, 0, WEST, new String[] {"f"}, 9, 0, WEST),
                arguments(9, 0, WEST, new String[] {"b"}, 0, 0, WEST),
                arguments(0, 0, SOUTH, new String[] {"f"}, 0, 9, SOUTH),
                arguments(0, 9, SOUTH, new String[] {"b"}, 0, 0, SOUTH)
        );
    }

    @Test
    void commands_process_are_interrupted_when_ostacle_are_found() {

        // given
        var x = 0; var y = 0;
        var facing = EAST;
        var rover = new MarsRover(
                x, y, facing,
                World.of(10, 10, List.of(Point.of(1, 0)))
        );

        // when
        rover.commands("F");
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                Location.of(Point.of(x, y), facing)
        );
    }
}
