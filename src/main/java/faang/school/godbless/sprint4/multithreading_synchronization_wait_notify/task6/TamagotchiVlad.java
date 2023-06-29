package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task6;

public class TamagotchiVlad {

    public synchronized void feed() {
        System.out.println(Thread.currentThread().getName() + " Vlad is feeding");
    }

    public synchronized void play() {
        System.out.println(Thread.currentThread().getName() + " Vlad is playing");
    }

    public synchronized void sleep() {
        System.out.println(Thread.currentThread().getName() + " Vlad is sleeping");
    }

    public synchronized void clean() {
        System.out.println(Thread.currentThread().getName() + " Vlad is cleaning");
    }
}
