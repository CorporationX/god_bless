package school.faang.godbless.bjs2_35878;

import java.util.ArrayList;
import java.util.List;

public class CountArmyPowerThread extends Thread {
    private List<Fighter> fighters = new ArrayList<>();
    private int power;

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }

    public int getPower() {
        return power;
    }

    @Override
    public void start() {
        power = fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}
