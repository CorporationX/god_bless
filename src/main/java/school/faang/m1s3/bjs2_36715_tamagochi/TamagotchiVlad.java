package school.faang.m1s3.bjs2_36715_tamagochi;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;

    public synchronized void sleep() {
        System.out.println(Thread.currentThread().getId() + " " + name + " sleeps at work");
        threadSleep();
        System.out.println(Thread.currentThread().getId() + " " + name + " is full of energy");
    }

    public synchronized void play() {
        System.out.println(Thread.currentThread().getId() + " " + name + " thinks he's good at Elden Ring");
        threadSleep();
        System.out.println(Thread.currentThread().getId() + " " + name + " died 67 times in the game");
    }

    public synchronized void clean() {
        System.out.println(Thread.currentThread().getId() + " " + name + " cleans his favorite pants");
        threadSleep();
        System.out.println(Thread.currentThread().getId() + " " + name + " is ready to go to the party");
    }

    public synchronized void feed() {
        System.out.println(Thread.currentThread().getId() + " " + name + " loves McDonalds");
        threadSleep();
        System.out.println(Thread.currentThread().getId() + " " + name + " is searching for WC");
    }

    private void threadSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}
