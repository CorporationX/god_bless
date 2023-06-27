package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Divisions;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Divisions> divisions = new ArrayList<>();

    public int calculateTotalPower() {
        return divisions.stream().mapToInt(Divisions::getPower).sum();
    }

    public void addUnit(Divisions divisions) throws InterruptedException {
        Thread thread = new Thread(() -> this.divisions.add(divisions));
        thread.start();
        thread.join();
    }
}
