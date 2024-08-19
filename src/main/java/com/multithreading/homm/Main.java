package com.multithreading.homm;

import com.multithreading.homm.Model.Archer;
import com.multithreading.homm.Model.Mage;
import com.multithreading.homm.Model.Swordsman;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Army army = new Army();
        army.addUnit(new Archer(20));
        army.addUnit(new Swordsman(50));
        army.addUnit(new Mage(30));
        army.addUnit(new Mage(35));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);

    }
}
