package school.faang.sprint3.task2;

import java.util.HashMap;
import java.util.Map;

public class Army {

    Map<Character, Thread> threadsToSumPower = new HashMap<>();

    private int totalPower;

    public void addUnit(Character character) {
        Thread thread = new Thread(() -> totalPower += character.getPower());
        threadsToSumPower.put(character, thread);
    }

    public int calculateTotalPower() {
        threadsToSumPower.forEach((character, thread) -> thread.start());
        threadsToSumPower.forEach((character, thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        });
        return totalPower;
    }

}