package faang.school.godbless.tamagochi;

import lombok.Getter;

@Getter
public class TamagotchiVlad {
    private boolean isHungry = true;
    private boolean isDirty = true;
    private boolean isSleeping = false;

    public synchronized void feed() {
        System.out.println(Thread.currentThread().getName() + " кормит Влада");
        isHungry = false;
    }

    public synchronized void play() {
        System.out.println(Thread.currentThread().getName() + " играет с Владом");
    }

    public synchronized void clean() {
        System.out.println(Thread.currentThread().getName() + " чистит Влада");
        isDirty = false;
    }

    public synchronized void sleep() {
        System.out.println(Thread.currentThread().getName() + " укладывает Влада спать");

        isSleeping = true;
    }

    public synchronized void wakeUp() {
        System.out.println(Thread.currentThread().getName() + " будит Влада");
        isSleeping = false;
    }
}
