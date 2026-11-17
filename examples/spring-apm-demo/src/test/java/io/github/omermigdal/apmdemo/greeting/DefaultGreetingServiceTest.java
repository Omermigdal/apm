package io.github.omermigdal.apmdemo.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultGreetingServiceTest {
    private final GreetingService service = new DefaultGreetingService();

    @Test
    void givenNameWhenGreetingThenReturnFormattedMessage() {
        assertThat(service.greet("Omer").message()).isEqualTo("Hello, Omer!");
    }

    @Test
    void givenWhitespaceWhenGreetingThenTrimName() {
        assertThat(service.greet("  Omer  ").message()).isEqualTo("Hello, Omer!");
    }
}
