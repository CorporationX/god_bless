package faang.school.godbless.threads.heroes;

import lombok.Getter;

@Getter
public class GetPower extends Thread {
    private final Hero hero;
    private int heroPower;
    public GetPower(Hero hero) {
        this.hero = hero;
    }

    public int getHeroPower() {
        return heroPower;
    }

    @Override
    public synchronized void run() {
        heroPower = hero.getPower();
    }
}
