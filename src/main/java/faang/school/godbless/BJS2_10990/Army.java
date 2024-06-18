package faang.school.godbless.BJS2_10990;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<Squad> army = new ArrayList<>();

    public void addUnit(Squad squad) {
        this.army.add(squad);
    }

    public int calculateTotalPower() {
        List<Integer> power = new ArrayList<>();
        this.army.forEach(squad -> {
            Thread thread = new Thread(() -> power.add(squad.getSquadPower()));
            thread.start();
        });
        return power.stream().reduce(Integer::sum).get();
    }
}
