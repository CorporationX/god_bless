package org.example.model.powerOfTheArmy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class CalculatePower extends Thread {
    private List<Warrior> warriorList;
    private int totalPower = 0;

    public CalculatePower(List<Warrior> warriors){
        this.warriorList = warriors;
    }

    @Override
    public void run() {
        warriorList.stream()
                .forEach(warrior -> totalPower += warrior.getPower());
    }
}
