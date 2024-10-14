package ru.kraiush.BJS2_35857;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());

        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
