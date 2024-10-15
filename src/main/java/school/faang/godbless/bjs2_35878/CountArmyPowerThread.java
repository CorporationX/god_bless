package school.faang.godbless.bjs2_35878;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CountArmyPowerThread extends Thread {
    private final List<Fighter> fighters = new ArrayList<>();
    @Getter
    private int power;

    public void addUnit(Fighter fighter) {
        fighters.add(fighter);
    }


    @Override
    public void start() {
        power = fighters.stream().mapToInt(Fighter::getPower).sum();
    }
}
