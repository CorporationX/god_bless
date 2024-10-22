package org.example.model.powerOfTheArmy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Warrior> warriors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            warriors.add(new Archer(random.nextInt(100)));
            warriors.add(new Swordsman(random.nextInt(100)));
            warriors.add(new Mage(random.nextInt(100)));
        }
        Army army = new Army(warriors);

        System.out.println(army.calculateTotalPower());
    }
}
