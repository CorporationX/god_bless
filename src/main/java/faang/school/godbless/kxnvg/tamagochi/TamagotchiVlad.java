package faang.school.godbless.kxnvg.tamagochi;

public class TamagotchiVlad {

    public synchronized void feed() {
        System.out.println(Thread.currentThread().getName() + " : Влад ест");
    }

    public synchronized void play() {
        System.out.println(Thread.currentThread().getName() + " : Влад играет");
    }

    public synchronized void clean() {
        System.out.println(Thread.currentThread().getName() + " : Влад убирается");
    }

    public synchronized void sleep() {
        System.out.println(Thread.currentThread().getName() + " : Влад спит");
    }
}
