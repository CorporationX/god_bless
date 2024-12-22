package school.faang.sprint_3.task_49549;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class TamagotchiVlad {
    private final String name;
    private boolean isFed = false;
    private boolean isHappy = false;
    private boolean isClean = false;
    private boolean isTired = true;


    public synchronized void feed() {
        System.out.println("Vlad " + name + " eats in " + Thread.currentThread().getName());
        isFed = true;
        isTired = true;
        System.out.println("Vlad info in " + Thread.currentThread().getName() + this);
    }

    public synchronized void play() {
        System.out.println("Vlad " + name + " plays in " + Thread.currentThread().getName());
        isHappy = true;
        isFed = false;
        System.out.println("Vlad info in " + Thread.currentThread().getName() + this);
    }

    public synchronized void clean() {
        System.out.println("Cleaning vlad " + name + " in " + Thread.currentThread().getName());
        isClean = true;
        isHappy = false;
        System.out.println("Vlad info in " + Thread.currentThread().getName() + this);
    }

    public synchronized void sleep() {
        System.out.println("Vlad " + name + " sleeps in " + Thread.currentThread().getName());
        isTired = false;
        isClean = false;
        System.out.println("Vlad info in " + Thread.currentThread().getName() + this);
    }
}
