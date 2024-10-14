package school.faang.calculatingheroesofmightandmagic;

import lombok.Getter;

public class HeroPowerCalculator extends Thread {
    private Hero hero;
    @Getter
    private int power;

    public HeroPowerCalculator(Hero hero) {
        this.hero = hero;
    }

    public void run() {
        power = hero.getPower();
        System.out.println(power + " : " + Thread.currentThread().getName());
    }
}
