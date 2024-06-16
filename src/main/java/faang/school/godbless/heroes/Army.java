package faang.school.godbless.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public static List<ThreadArmy> threadArmies = new ArrayList<>();

    public void addWarrior(Warriors warriors) {
        threadArmies.add(new ThreadArmy(warriors));
    }

    public int calculateTotalStrengthArmy() throws InterruptedException {
        return threadArmies.stream()
                .peek(a -> a.start())
                .peek(a -> {
                    try {
                        a.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Поток прерван");
                    }
                })
                .mapToInt(a -> a.getAllPower())
                .sum();

    }
}

