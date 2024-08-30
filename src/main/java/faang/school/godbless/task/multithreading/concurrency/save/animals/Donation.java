package faang.school.godbless.task.multithreading.concurrency.save.animals;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
public class Donation {
    private final AtomicLong idCounter;
    private final long id = idCounter.incrementAndGet();
    private final long donationAmount;
}
