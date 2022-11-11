package dev.ifrs;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

public class CoffeeRepositoryService<Coffee> {

    private AtomicLong counter = new AtomicLong(0);

    @CircuitBreaker(requestVolumeThreshold = 4)
    public Integer getAvailability(Coffee coffee) {
        maybeFail();
        return new Random().nextInt(30);
    }

    private void maybeFail() {
        // introduce some artificial failures
        final Long invocationNumber = counter.getAndIncrement();
        if (invocationNumber % 4 > 1) { // alternate 2 successful and 2 failing invocations
            throw new RuntimeException("Service failed.");
        }
    }
}