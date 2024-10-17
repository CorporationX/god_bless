package school.faang.tamagotchi;

import lombok.Getter;

@Getter
public class TamagotchiVlad {
    private static final int TIME_TO_WORK = 100;
    private String name;
    private String status = "нейтральный";

    protected TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        try {
            Thread.sleep(TIME_TO_WORK);
            status = "сыт";
            System.out.println(name + " ест. Его состояние " + status);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void play() {
        try {
            Thread.sleep(TIME_TO_WORK);
            status = "весел";
            System.out.println(name + " играет. Его состояние " + status);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void clean() {
        try {
            Thread.sleep(TIME_TO_WORK);
            status = "чист";
            System.out.println(name + " чистится. Его состояние " + status);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void  sleep() {
        try {
            Thread.sleep(TIME_TO_WORK);
            status = "спит";
            System.out.println(name + " спит. Его состояние " + status);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}