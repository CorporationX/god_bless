package ru.maks1979.task_48134;

public class Main {
    public static void main(String[] args) {

        Army army = new Army();
        army.listAdd(new Archer(25));
        army.listAdd(new Swordsman(40));
        army.listAdd(new Mage(50));
        army.listAdd(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}

