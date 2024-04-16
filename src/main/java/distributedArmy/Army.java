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

        army.forEach((squad) -> {
            ArmyThread thread = new ArmyThread(squad);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalPower += thread.getTotalPower();
        });

        return totalPower;
    }
}
