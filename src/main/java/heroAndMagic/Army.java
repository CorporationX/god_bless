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

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread((Runnable) armyList.get(i));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < 4; i++) {
            result += armyList.get(i).getTotal();
        }


        return result;
    }

}
