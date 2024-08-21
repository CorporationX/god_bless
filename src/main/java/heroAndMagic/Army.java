package heroAndMagic;

import lombok.Getter;

import java.util.*;

@Getter
public class Army {

    private static List<Character> armyList = new ArrayList<>();

    public static void addUnit(Character character) {
        armyList.add(character);
    }

    public static int calculateTotalPower() {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread((Runnable) armyList.get(i));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            result += armyList.get(i).getTotal();
        }
        return result;
    }

}
