package faang.school.godbless.multithreading.tamagotchi_Vlad;

import lombok.Getter;

public class TamagotchiVlad {
    @Getter
    private String name;
    private static int counter;
    private boolean isWorking;

    public TamagotchiVlad() {
        counter++;
        name = "Vlad " + counter;
        isWorking = false;
    }

    public synchronized void play() {
        isWorking = true;
        System.out.println(name + " plays... | " + Thread.currentThread().getName());
        notify();
        detain();
        System.out.println(name + " played. | " + Thread.currentThread().getName());
        isWorking = false;
        notify();
    }

    public synchronized void feed() {
        isWorking = true;
        System.out.println(name + " eats... | " + Thread.currentThread().getName());
        notify();
        detain();
        System.out.println(name + " ate. | " + Thread.currentThread().getName());
        isWorking = false;
        notify();
    }

    public synchronized void clean() {
        isWorking = true;
        System.out.println(name + " washes... | " + Thread.currentThread().getName());
        notify();
        detain();
        System.out.println(name + " washed himself. | " + Thread.currentThread().getName());
        isWorking = false;
        notify();
    }

    public synchronized void sleep() {
        isWorking = true;
        System.out.println(name + " is sleeping... | " + Thread.currentThread().getName());
        notify();
        detain();
        System.out.println(name + " slept. | " + Thread.currentThread().getName());
        isWorking = false;
        notify();
    }

    private void detain() {
        try {
            wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWorking() {
        return isWorking;
    }
}
