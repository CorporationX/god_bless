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
        int[] sumArray = new int[3];

        Thread firstSquadPower = new Thread(() -> {
            sumArray[0] = fullArmy.get(0).calculateSquadPower();
            System.out.println("Поток 1 выполнен");
        });
        Thread secondSquadPower = new Thread(() -> {
            sumArray[1] = fullArmy.get(1).calculateSquadPower();
            System.out.println("Поток 2 выполнен");
        });
        Thread thirdSquadPower = new Thread(() -> {
            sumArray[2] = fullArmy.get(2).calculateSquadPower();
            System.out.println("Поток 3 выполнен");
        });

        firstSquadPower.start();
        secondSquadPower.start();
        thirdSquadPower.start();

        try {
            firstSquadPower.join();
            secondSquadPower.join();
            thirdSquadPower.join();
            System.out.println("Все потоки успешно выполнены");
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
