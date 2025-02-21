package school.faang.bjs2_60723;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final Random RANDOM = new Random();
    private final String title;

    @Override
    public void run() {
        System.out.printf("%s started execution in thread %s\n", title, Thread.currentThread().getName());
        try {
            Thread.sleep(1000 + RANDOM.nextInt(3000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while executing chore: " + title, e);
        }
        System.out.printf("%s finished executing in thread %s\n", title, Thread.currentThread().getName());
    }
}
