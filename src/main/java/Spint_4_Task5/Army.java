package Spint_4_Task5;

import java.util.ArrayList;
import java.util.List;

public class Army implements Runnable {
    List<Entity> entityList;

    public Army() {
        this.entityList = new ArrayList<>();
    }

    public int calculateTotalPower() {

        return 0;
    }

    @Override
    public void run() {
        System.out.println("Total army power: " + calculateTotalPower());
    }

    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

    private void addUnit(Entity entity) {
        entityList.add(entity);
    }
}
