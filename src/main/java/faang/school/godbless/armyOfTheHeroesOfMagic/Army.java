package faang.school.godbless.armyOfTheHeroesOfMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Warrior> warriors = new ArrayList<>();;


    public void addUnit(Warrior warrior) {
        warriors.add(warrior);
    }

    public double calculateTotalPower() {
        return warriors.parallelStream()
                .mapToDouble(Warrior::getPower)
                .sum();
    }
}
