package faang.school.godbless.multithreading.tamagotchi_Vlad;

import lombok.Getter;

@Getter
public class TamagotchiVlad {

    private String name;
    private static int counter;
    private boolean isWorking;
    private int happiness;

    public TamagotchiVlad() {
        counter++;
        name = "Vlad " + counter;
    }

    public synchronized void play() {
        notifyAll();
        isWorking = true;
        System.out.println(name + " plays... | " + Thread.currentThread().getName());
        detain();
        System.out.println(name + " played. | " + Thread.currentThread().getName());
        happiness++;
        isWorking = false;
    }

    public synchronized void feed() {
        notifyAll();
        isWorking = true;
        System.out.println(name + " eats... | " + Thread.currentThread().getName());
        detain();
        System.out.println(name + " ate. | " + Thread.currentThread().getName());
        happiness++;
        isWorking = false;
    }

    public synchronized void clean() {
        notifyAll();
        isWorking = true;
        System.out.println(name + " washes... | " + Thread.currentThread().getName());
        detain();
        System.out.println(name + " washed himself. | " + Thread.currentThread().getName());
        happiness++;
        isWorking = false;
    }

    public synchronized void sleep() {
        notifyAll();
        isWorking = true;
        System.out.println(name + " is sleeping... | " + Thread.currentThread().getName());
        detain();
        System.out.println(name + " slept. | " + Thread.currentThread().getName());
        happiness++;
        isWorking = false;
    }

    private void detain() {
        try {
            wait(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
