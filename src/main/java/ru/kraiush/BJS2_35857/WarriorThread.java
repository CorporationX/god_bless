package ru.kraiush.BJS2_35857;

import lombok.Getter;

@Getter
public class WarriorThread extends Thread {
    private int countPower;
    private final Warrior warrior;

    public WarriorThread(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void run() {
        countPower += warrior.getPower();
    }
}
