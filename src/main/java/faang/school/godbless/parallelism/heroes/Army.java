package faang.school.godbless.parallelism.heroes;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public static List<ThreadArmy> threadArmies = new ArrayList<>();

    public void addWarrior(Warriors warriors) {
        threadArmies.add(new ThreadArmy(warriors));
    }

    public int calculateTotalStrengthArmy() throws InterruptedException {
        startTread();
        return threadArmies.stream()
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

    private void startTread() {
        threadArmies.stream()
                .forEach(a -> a.start());
    }
}

