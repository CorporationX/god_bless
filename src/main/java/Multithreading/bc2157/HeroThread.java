package Multithreading.bc2157;

public class HeroThread extends Thread {
    private final Hero hero;
    private int power;

    public HeroThread(Hero hero) {
        this.hero = hero;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void run() {
        this.power = hero.getPower();
    }
}
