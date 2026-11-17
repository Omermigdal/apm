package io.github.omermigdal.apmdemo.greeting;

import org.springframework.stereotype.Service;

@Service
public final class DefaultGreetingService implements GreetingService {
    @Override
    public GreetingResponse greet(String name) {
        return new GreetingResponse("Hello, %s!".formatted(name.strip()));
    }
}
