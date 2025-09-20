package school.faang.bjs2_90409;

public class TamagotchiVlad {
    private final Object lock = new Object();

    public void feed() {
        synchronized (lock) {
            System.out.println("Влад кушает.");
        }
    }

    public void play() {
        synchronized (lock) {
            System.out.println("Влад играет.");
        }
    }

    public void clean() {
        synchronized (lock) {
            System.out.println("Влад чистится.");
        }
    }

    public void sleep() {
        synchronized (lock) {
            System.out.println("Влад спит.");
        }
    }
}
