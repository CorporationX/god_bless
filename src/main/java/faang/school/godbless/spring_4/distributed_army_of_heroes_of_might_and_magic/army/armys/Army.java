package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.GatheringPower;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Divisions;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Divisions> divisions = new ArrayList<>();

    public int calculateTotalPower() {
        for (Divisions division : divisions) {
            new Thread(new GatheringPower(division));
        }

        return GatheringPower.getPower();
    }

    public void addUnit(Divisions division) throws InterruptedException {
        divisions.add(division);
    }
}
