package faang.school.godbless.sprint3.vlad;

public class TamagotchiVlad {
    public synchronized void feed() {
        System.out.println("Feeding");
    }
    public synchronized void play() {
        System.out.println("Playing");
    }
    public synchronized void sleep() {
        System.out.println("Sleeping");
    }
    public synchronized void clean() {
        System.out.println("Cleaning");
    }
}
