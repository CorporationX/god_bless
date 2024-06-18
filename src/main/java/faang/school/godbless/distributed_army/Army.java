package faang.school.godbless.distributed_army;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final int NUMBER_OF_THREADS = 4;

    private final List<Character> characterList = new ArrayList<>();

    public int calculateTotalPower() {
        List<Thread> threadPool = new ArrayList<>();
        AtomicInteger totalPower = new AtomicInteger();

        for (Character character : characterList) {
            Thread powerComputingThread = new Thread(
                    () -> totalPower.getAndAdd(character.getPower())
            );

            powerComputingThread.start();
            threadPool.add(powerComputingThread);
        }

        for (Thread powerComputingThread : threadPool) {
            try {
                powerComputingThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Caught Interrupted Exception " + e.getMessage());
            }
        }

        return totalPower.get();
    }

    public void addUnit(Character characterToAdd) {
        characterList.add(characterToAdd);
    }
}
