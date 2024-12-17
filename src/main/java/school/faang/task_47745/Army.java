package school.faang.task_47745;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {

    private static List<Hero> heroes = new ArrayList<>();

    public void addUnit(Hero hero) {
        heroes.add(hero);
    }

    public long calculateTotalPower() throws InterruptedException {
        int totalPower = 0;

        for (Hero hero : heroes) {
            HeroThread heroThread = new HeroThread(hero);
            heroThread.start();
            heroThread.join();
            totalPower += heroThread.getPower();
        }


        return totalPower;
    }
}
