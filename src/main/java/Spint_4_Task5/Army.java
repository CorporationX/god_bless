package Spint_4_Task5;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> units;

    public Army() {
        this.units = new ArrayList<>();
    }


    @SneakyThrows
    public int calculateTotalPower() {
        List<Thread> threads = new ArrayList<>();
        List<TreedPower> treedPowers = new ArrayList<>();
        for (Unit unit : units) {
            TreedPower treed = new TreedPower(unit);
            treedPowers.add(treed);
            threads.add(new Thread(treed));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        return treedPowers.stream().mapToInt(TreedPower::getPower).sum();
    }
    private void addUnit(Unit entity) {
        units.add(entity);
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
