package school.faang.bjs2_91325;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private int power;
    private final List<Squad> fullArmy = new ArrayList<>();

    public Army(int power) {
        this.power = power;
    }

    public Army() {
    }

    public int calculateTotalPower() {
        int[] sumArray = new int[fullArmy.size()];
        Thread[] threads = new Thread[fullArmy.size()];

        for (int i = 0; i < sumArray.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> sumArray[index] = fullArmy.get(index).calculateSquadPower());
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        int sum = 0;
        for (int array : sumArray) {
            sum += array;
        }
        return sum;
    }
}
