package ru.maks1979.task_48134;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    @Getter
    @Setter
    private List<Fighter> listOfFighters = new ArrayList<>();

    public void listAdd(Fighter fighter) {
        listOfFighters.add(fighter);
    }

    public int calculateTotalPower() {
        AtomicInteger total1 = new AtomicInteger();
        Thread archerThread = new Thread(() -> total1.set(listOfFighters.stream()
                .filter(arch -> arch instanceof Archer)
                .mapToInt(arch -> ((Archer) arch).getPower()).sum()));
        archerThread.start();
        try {
            archerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AtomicInteger total2 = new AtomicInteger();
        Thread mageThread = new Thread(() -> total2.set(listOfFighters.stream()
                .filter(mag -> mag instanceof Mage)
                .mapToInt(mag -> ((Mage) mag).getPower()).sum()));
        mageThread.start();
        try {
            mageThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AtomicInteger total3 = new AtomicInteger();
        Thread swordsmanThread = new Thread(() -> total3.set(listOfFighters.stream()
                .filter(swman -> swman instanceof Swordsman)
                .mapToInt(swman -> ((Swordsman) swman).getPower()).sum()));
        swordsmanThread.start();
        try {
            swordsmanThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return total1.get() + total2.get() + total3.get();
    }
}


