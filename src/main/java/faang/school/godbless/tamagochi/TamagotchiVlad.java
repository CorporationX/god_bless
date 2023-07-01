package faang.school.godbless.tamagochi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TamagotchiVlad {
    private String name;

    public TamagotchiVlad(String name){
        this.name = name;
    }

    public synchronized void feed() throws InterruptedException {
        System.out.println("Feeding");
    }

    public synchronized void play() throws InterruptedException {
        System.out.println("Playing");

    }

    public void clean() throws InterruptedException {
        System.out.println("Cleaning");
    }

    public void sleep() throws InterruptedException {
        System.out.println("Sleeping");
    }
}

