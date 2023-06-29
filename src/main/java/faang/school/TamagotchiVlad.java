package faang.school;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagotchiVlad {
    private int id;

    public synchronized void feed() {
        System.out.println(id + " id being fed");
    }

    public synchronized void play() {
        System.out.println(id + " id playing");
    }

    public synchronized void clean() {
        System.out.println(id + " is being cleaned");
    }

    public synchronized void sleep() {
        System.out.println(id + " is sleeping");
    }
}
