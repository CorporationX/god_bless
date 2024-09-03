package faang.school.godbless.BJS2_24181;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final long id;

    public synchronized void feed() {
        System.out.println("Vlad" + id + " is feeding");
        waitingForActivity();
        System.out.println("Vlad" + id + " is fed");

    }

    public synchronized void play() {
        System.out.println("Vlad" + id + " is playing");
        waitingForActivity();
        System.out.println("Vlad" + id + " ended to play");
    }

    public synchronized void clean() {
        System.out.println("Vlad" + id + " is cleaning");
        waitingForActivity();
        System.out.println("Vlad" + id + " ended to clean");
    }

    public synchronized void sleep() {
        System.out.println("Vlad" + id + " is sleeping");
        waitingForActivity();
        System.out.println("Vlad" + id + " woke up");
    }

    private void waitingForActivity() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
