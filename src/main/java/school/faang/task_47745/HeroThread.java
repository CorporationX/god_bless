package school.faang.task_47745;

import lombok.Getter;

@Getter
public class HeroThread extends Thread {
    private final Hero hero;
    private int power;

    public HeroThread(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        this.power = hero.getPower();
    }
}
