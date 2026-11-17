package io.github.omermigdal.apmdemo.greeting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/greetings")
@RequiredArgsConstructor
public final class GreetingController {
    private final GreetingService greetingService;

    @GetMapping
    public GreetingResponse greeting(@RequestParam(defaultValue = "world")
                                     @NotBlank @Size(max = 80) String name) {
        return greetingService.greet(name);
    }
}
