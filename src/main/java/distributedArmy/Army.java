package distributedArmy;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    private static final List<Character> ARMY = new ArrayList<>();

    public void addUnit(Character character) {
        ARMY.add(character);
    }

    public void calculateTotalPower() {
        for (int i = 0; i < ARMY.size(); i++) {
            int j = i;
            new Thread(() -> {
                System.out.println(String.format("Squad: %s\nTotal Power of squad: %d\n",
                        ARMY.get(j).getClass(), ARMY.get(j).getPower() * ARMY.get(j).getAmount()));

            }).start();
        }
    }
}
