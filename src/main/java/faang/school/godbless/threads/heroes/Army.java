package faang.school.godbless.threads.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static final List<Hero> heroList = new ArrayList<>();

    public void addUnit(Hero hero) {
        heroList.add(hero);
    }

    public int calculateTotalPower() {
        List<GetPower> threads = new ArrayList<>();
        for (Hero hero : heroList) {
            GetPower getPower = new GetPower(hero);
            getPower.start();
            threads.add(getPower);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return threads.stream().map(getPower -> getPower.getHeroPower()).reduce(0, Integer::sum);
    }
}
