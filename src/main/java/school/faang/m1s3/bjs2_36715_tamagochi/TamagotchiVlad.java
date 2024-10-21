package school.faang.m1s3.bjs2_36715_tamagochi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;

    public synchronized void sleep() {
        System.out.printf("%d %s sleeps at work%n", Thread.currentThread().getId(), name);
        threadSleep();
        System.out.printf("%d %s is full of energy%n", Thread.currentThread().getId(), name);
    }

    public synchronized void play() {
        System.out.printf("%d %s thinks he's good at Elden Ring%n", Thread.currentThread().getId(), name);
        threadSleep();
        System.out.printf("%d %s died 67 times in the game%n", Thread.currentThread().getId(), name);
    }

    public synchronized void clean() {
        System.out.printf("%d %s cleans his favorite pants%n", Thread.currentThread().getId(), name);
        threadSleep();
        System.out.printf("%d %s is ready to go to the party%n", Thread.currentThread().getId(), name);
    }

    public synchronized void feed() {
        System.out.printf("%d %s loves McDonalds%n", Thread.currentThread().getId(), name);
        threadSleep();
        System.out.printf("%d %s is searching for WC%n", Thread.currentThread().getId(), name);
    }

    private void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted {}", e.getMessage(), e);
        }
    }
}
