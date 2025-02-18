package school.faang.bjs2_60723;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        System.out.printf("%s started execution in thread %s\n", title, Thread.currentThread().getName());
        try {
            Thread.sleep(1000 + new Random().nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finished executing in thread %s\n", title, Thread.currentThread().getName());
    }
}
