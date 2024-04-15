package faang.school.godbless.distributed_army_of_heroes_of_might_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Division> allDivisions = new ArrayList<>();
    private int totalPower = 0;

    public int calculateTotalPower() throws InterruptedException {

        for (Division division : allDivisions) {

            Thread thread = new Thread(() -> totalPower += division.getPower());
            thread.start();
            thread.join();

        }

        return totalPower;
    }

    public void addUnit(Division division) {
        allDivisions.add(division);
    }
}
