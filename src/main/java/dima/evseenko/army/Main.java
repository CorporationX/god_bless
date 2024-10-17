package dima.evseenko.army;

import dima.evseenko.army.unit.Archer;
import dima.evseenko.army.unit.Mage;
import dima.evseenko.army.unit.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(15));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(70));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(10));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
