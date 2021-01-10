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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MarsRoverShould {

    @Test
    void retrieve_initial_position_when_no_commands_provided() {
        // given
        var initX = 0;
        var initY = 0;
        var initFacing = NORTH;
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands();
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                Location.of(Point.of(initX, initY), initFacing)
        );
    }

    @Test
    void throw_exception_when_command_are_unknown() {
        // given
        var rover = new MarsRover(
                0, 0, NORTH,
                World.of(10, 10, List.empty())
        );

        // when
        assertThatThrownBy(() -> rover.commands("X"))
            .hasMessage("Unknown command key: X");
    }

    @ParameterizedTest
    @MethodSource("forwardCommand")
    void retrieve_actual_position_when_pass_forward_command(int initX, int initY, Direction initFacing,
                                                            String[] commands,
                                                            Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> forwardCommand() {
        return Stream.of(
                // forward/backward commands
                arguments(0, 0, EAST, new String[] {"F"}, Location.of(Point.of(1, 0), EAST)),
                arguments(0, 0, NORTH, new String[] {"F"}, Location.of(Point.of(0, 1), NORTH)),
                arguments(1, 1, WEST, new String[] {"F"}, Location.of(Point.of(0, 1), WEST)),
                arguments(1, 1, SOUTH, new String[] {"F"}, Location.of(Point.of(1, 0), SOUTH))
        );
    }

    @ParameterizedTest
    @MethodSource("backwardCommand")
    void retrieve_actual_position_when_pass_backward_command(int initX, int initY, Direction initFacing,
                                                             String[] commands,
                                                             Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> backwardCommand() {
        return Stream.of(
                arguments(1, 1, EAST, new String[] {"B"}, Location.of(Point.of(0, 1), EAST)),
                arguments(1, 1, NORTH, new String[] {"B"}, Location.of(Point.of(1, 0), NORTH)),
                arguments(0, 0, WEST, new String[] {"B"}, Location.of(Point.of(1, 0), WEST)),
                arguments(0, 0, SOUTH, new String[] {"B"}, Location.of(Point.of(0, 1), SOUTH))
        );
    }

    @ParameterizedTest
    @MethodSource("rightCommand")
    void retrieve_actual_position_when_pass_right_command(int initX, int initY, Direction initFacing,
                                                          String[] commands,
                                                          Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> rightCommand() {
        return Stream.of(
                arguments(1, 1, NORTH, new String[] {"R"}, Location.of(Point.of(1, 1), EAST)),
                arguments(1, 1, SOUTH, new String[] {"R"}, Location.of(Point.of(1, 1), WEST)),
                arguments(1, 1, EAST, new String[] {"R"}, Location.of(Point.of(1, 1), SOUTH)),
                arguments(1, 1, WEST, new String[] {"R"}, Location.of(Point.of(1, 1), NORTH))
        );
    }

    @ParameterizedTest
    @MethodSource("leftCommand")
    void retrieve_actual_position_when_pass_left_command(int initX, int initY, Direction initFacing,
                                                         String[] commands,
                                                         Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> leftCommand() {
        return Stream.of(
                arguments(1, 1, NORTH, new String[] {"L"}, Location.of(Point.of(1, 1), WEST)),
                arguments(1, 1, SOUTH, new String[] {"L"}, Location.of(Point.of(1, 1), EAST)),
                arguments(1, 1, EAST, new String[] {"L"}, Location.of(Point.of(1, 1), NORTH)),
                arguments(1, 1, WEST, new String[] {"L"}, Location.of(Point.of(1, 1), SOUTH))
        );
    }

    @Test
    void process_several_commands() {
        // given
        var initX = 1;
        var initY = 1;
        var initFacing = NORTH;
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands("B", "F", "F");
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                Location.of(Point.of(1, 2), NORTH)
        );
    }

    @ParameterizedTest
    @MethodSource("lowerCaseCommands")
    void commands_are_case_insensitive(int initX, int initY, Direction initFacing,
                                       String[] commands,
                                       Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> lowerCaseCommands() {
        return Stream.of(
                arguments(0, 0, EAST, new String[] {"f"}, Location.of(Point.of(1, 0), EAST)),
                arguments(0, 1, NORTH, new String[] {"b"}, Location.of(Point.of(0, 0), NORTH)),
                arguments(1, 1, WEST, new String[] {"r"}, Location.of(Point.of(1, 1), NORTH)),
                arguments(1, 1, SOUTH, new String[] {"l"}, Location.of(Point.of(1, 1), EAST))
        );
    }

    @ParameterizedTest
    @MethodSource("beyondLimits")
    void return_to_init_location_when_limits(int initX, int initY, Direction initFacing,
                                             String[] commands,
                                             Location expectedLocation) {
        // given
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, List.empty())
        );

        // when
        rover.commands(commands);
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                expectedLocation
        );
    }

    static Stream<Arguments> beyondLimits() {
        return Stream.of(
                arguments(0, 0, NORTH, new String[] {"B"}, Location.of(Point.of(0, 9), NORTH)),
                arguments(0, 9, NORTH, new String[] {"F"}, Location.of(Point.of(0, 0), NORTH)),
                arguments(0, 0, EAST, new String[] {"B"}, Location.of(Point.of(9, 0), EAST)),
                arguments(9, 0, EAST, new String[] {"F"}, Location.of(Point.of(0, 0), EAST)),
                arguments(0, 0, WEST, new String[] {"F"}, Location.of(Point.of(9, 0), WEST)),
                arguments(9, 0, WEST, new String[] {"B"}, Location.of(Point.of(0, 0), WEST)),
                arguments(0, 0, SOUTH, new String[] {"F"}, Location.of(Point.of(0, 9), SOUTH)),
                arguments(0, 9, SOUTH, new String[] {"B"}, Location.of(Point.of(0, 0), SOUTH))
        );
    }

    @Test
    void commands_process_are_interrupted_when_obstacle_are_found() {

        // given
        var initX = 0;
        var initY = 0;
        var initFacing = EAST;
        var obstacles = List.of(Point.of(1, 0));
        var rover = new MarsRover(
                initX, initY, initFacing,
                World.of(10, 10, obstacles)
        );

        // when
        rover.commands("F");
        Location actualLocation = rover.location();

        // then
        assertThat(
                actualLocation
        ).isEqualTo(
                Location.of(Point.of(initX, initY), initFacing)
        );
    }
}
