package faang.school.godbless.multithreading.heroesofmagic;

import java.util.ArrayList;
import java.util.List;

public class Army {

    public final List<Character> divisions = new ArrayList<>();

    public int calculateTotalPower() {
        List<CustomThread> customThreads = new ArrayList<>();
        for (Character character: divisions) {
            CustomThread thread = new CustomThread(character);
            thread.start();
            customThreads.add(thread);
        }

        for (Thread thread: customThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return customThreads.stream()
                .map(CustomThread::getPower)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void addUnit(Character character) {
        divisions.add(character);
    }
}