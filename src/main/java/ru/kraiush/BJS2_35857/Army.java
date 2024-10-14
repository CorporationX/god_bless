package ru.kraiush.BJS2_35857;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {
    private List<Warrior> army = new ArrayList<>();

    public void addUnit(Warrior warrior) {
        army.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<WarriorThread> threads = new ArrayList<>();
        for (Warrior warrior : army) {
            WarriorThread thread = new WarriorThread(warrior);
            threads.add(thread);
            thread.start();
        }
        for (WarriorThread thread : threads) {
            thread.join();
            totalPower += thread.getCountPower();
        }
        return totalPower;
    }
}
