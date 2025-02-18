package school.faang.sprint3.multithreading.bjs2_61400;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Army {
    private final List<Squad> squads;

    public Army(List<Squad> squads) {
        this.squads = squads;
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Squad squad : squads) {
            Thread thread = new Thread(squad);
            thread.start();
        }
        Thread.sleep(1000);
        int totalArmyPower = 0;
        for (Squad squad : squads) {
            totalArmyPower += squad.getTotalSquadPower();
        }
        return totalArmyPower;
    }
}
