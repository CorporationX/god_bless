package school.faang.sprint3.task2;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private final List<Thread> threadsToSumPower = new ArrayList<>();
    //private final List<Character> characters = new ArrayList<>();

    private int totalPower;

    public void addUnit(Character character) {
        Thread thread = new Thread(() -> totalPower += character.getPower());
        threadsToSumPower.add(thread);
        //characters.add(character);
    }

    public int calculateTotalPower() {
        threadsToSumPower.forEach(Thread::start);
        threadsToSumPower.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        });
        return totalPower;
    }

}