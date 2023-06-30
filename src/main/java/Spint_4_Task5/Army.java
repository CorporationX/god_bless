package Spint_4_Task5;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Entity> entityList;

    public Army() {
        this.entityList = new ArrayList<>();
    }


    @SneakyThrows
    public int calculateTotalPower() {
        List<Thread> treedArrayList = new ArrayList<>();
        List<TreedPower> treedPowerArrayList = new ArrayList<>();
        for (Entity entity : entityList) {
            TreedPower treed = new TreedPower(entity);
            treedPowerArrayList.add(treed);
            treedArrayList.add(new Thread(treed));
        }
        for (Thread thread : treedArrayList) {
            thread.start();
        }
        for (Thread thread : treedArrayList) {
            thread.join();
        }
        return treedPowerArrayList.stream().mapToInt(TreedPower::getPower).sum();
    }
    private void addUnit(Entity entity) {
        entityList.add(entity);
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


}
