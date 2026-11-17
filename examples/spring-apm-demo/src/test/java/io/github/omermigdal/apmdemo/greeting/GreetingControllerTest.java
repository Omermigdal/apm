package io.github.omermigdal.apmdemo.greeting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GreetingControllerTest {
    @Test
    void givenNameWhenControllerInvokedThenDelegateToService() {
        GreetingService service = mock(GreetingService.class);
        GreetingResponse expected = new GreetingResponse("Hello, Omer!");
        when(service.greet("Omer")).thenReturn(expected);
        GreetingController controller = new GreetingController(service);

        GreetingResponse result = controller.greeting("Omer");

        assertThat(result).isEqualTo(expected);
        verify(service).greet("Omer");
    }
}
