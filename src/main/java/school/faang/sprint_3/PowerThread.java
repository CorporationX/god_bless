package school.faang.sprint_3;

import lombok.Getter;

import java.util.List;

public class PowerThread extends Thread {
    @Getter
    private int powerSum = 0;
    private List<Hero> heroes;

    public PowerThread(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public void run() {
        for (var hero : heroes) {
            powerSum += hero.getPower();
        }
    }
}
