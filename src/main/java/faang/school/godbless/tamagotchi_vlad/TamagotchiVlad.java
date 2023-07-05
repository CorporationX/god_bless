package faang.school.godbless.tamagotchi_vlad;

public class TamagotchiVlad {
    public synchronized void feed() {
        System.out.println("Vlad had a delicious meal!");
    }

    public synchronized void play() {
        System.out.println("Vlad played!");
    }

    public synchronized void clean() {
        System.out.println("Vlad is very clean!");
    }

    public synchronized void sleep() {
        System.out.println("Vlad had a good sleep!");
    }
}
