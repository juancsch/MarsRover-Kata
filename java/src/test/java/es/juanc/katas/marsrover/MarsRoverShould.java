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
                arguments(Location.of(0, 0, E), new String[] {""}, Location.of(0, 0, E)),
                arguments(Location.of(0, 0, E), new String[] {"f"}, Location.of(1, 0, E))
        );
    }
}
