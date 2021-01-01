package es.juanc.katas.marsrover;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static es.juanc.katas.marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MarsRoverShould {

    @ParameterizedTest
    @MethodSource("starLocationCommandsAndExpectedLocation")
    void retrieve_actual_position_after_command_introduced(Location startLocation, String[] commands, Location expectedLocation) {

        // given
        var rover = new MarsRover(startLocation);

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

    static Stream<Arguments> starLocationCommandsAndExpectedLocation() {
        return Stream.of(
                arguments(Location.of(0, 0, EAST), new String[] {}, Location.of(0, 0, EAST)),
                arguments(Location.of(0, 0, EAST), new String[] {"F"}, Location.of(1, 0, EAST)),
                arguments(Location.of(0, 0, NORTH), new String[] {"f"}, Location.of(0, 1, NORTH)),
                arguments(Location.of(1, 1, WEST), new String[] {"F"}, Location.of(0, 1, WEST)),
                arguments(Location.of(1, 1, SOUTH), new String[] {"f"}, Location.of(1, 0, SOUTH)),
                arguments(Location.of(1, 1, EAST), new String[] {"B"}, Location.of(0, 1, EAST)),
                arguments(Location.of(1, 1, NORTH), new String[] {"b"}, Location.of(1, 0, NORTH)),
                arguments(Location.of(0, 0, WEST), new String[] {"B"}, Location.of(1, 0, WEST)),
                arguments(Location.of(0, 0, SOUTH), new String[] {"b"}, Location.of(0, 1, SOUTH)),
                arguments(Location.of(1, 1, NORTH), new String[] {"b", "F", "f"}, Location.of(1, 2, NORTH))
        );
    }
}
