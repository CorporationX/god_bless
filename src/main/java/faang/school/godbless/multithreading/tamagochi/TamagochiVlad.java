package faang.school.godbless.multithreading.tamagochi;

import lombok.Getter;

@Getter
public class TamagochiVlad {
    private final String name;
    private Condition condition;

    public TamagochiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        condition = Condition.EATING;
    }

    public synchronized void play() {
        condition = Condition.PLAYING;
    }

    public synchronized void clean() {
        condition = Condition.CLEANING;
    }

    public synchronized void sleep() {
        condition = Condition.SLEEPING;
    }

    public void getCondition() {
        System.out.println(name + " is "  + condition + " | current thread is " + Thread.currentThread().getName());
    }
}
