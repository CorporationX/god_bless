package distributedArmy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    private List<Character> army = new ArrayList<>();
    private int totalPower;

    public void addUnit(Character character) {
        army.add(character);
    }

    public int calculateTotalPower() {

        List<ArmyThread> armyThreads = new ArrayList<>();
        army.forEach((squad) -> {
            ArmyThread thread = new ArmyThread(squad);
            armyThreads.add(thread);
            thread.start();
        });

        armyThreads.forEach(armyThread -> {
            try {
                totalPower += armyThread.getTotalPower();
                armyThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return totalPower;
    }
}
