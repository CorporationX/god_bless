package org.example.model.powerOfTheArmy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Army {
    private List<Warrior> warriors;

    public void addWarrior(Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() {
        List<CalculatePower> calculatePowers = new ArrayList<>();
        int totalPower = 0;
        Map<String, List<Warrior>> groupedWarriors = warriors.stream()
                .collect(Collectors.groupingBy(warrior -> warrior.getClass().getName()));

        groupedWarriors.forEach((key, value) -> {
            CalculatePower calculatePower = new CalculatePower(value);
            calculatePowers.add(calculatePower);
            Thread thread = new Thread(calculatePower);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        for (CalculatePower calculatePower : calculatePowers) {
            totalPower += calculatePower.getTotalPower();
        }

        return totalPower;
    }
}
