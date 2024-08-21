package faang.school.godbless.task32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Army {
    public static List<Unit> army = new ArrayList<>();
    List<Unit> mages = new ArrayList<>();
    List<Unit> archers = new ArrayList<>();
    List<Unit> swordsman = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25)); // считаем в потоке 1
        army.addUnit(new Swordsman(40)); // считаем в потоке 2
        army.addUnit(new Mage(50)); // считаем в потоке 3
        army.addUnit(new Mage(20)); // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
    public void addUnit(Unit unit){
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger swordsmanPower = new AtomicInteger(0);
        AtomicInteger archerPower = new AtomicInteger(0);
        AtomicInteger magePower = new AtomicInteger(0);

        for (Unit unit : army) {
            if (unit.isMage()) {
                mages.add(unit);
            }
            if (unit.isArcher()) {
                archers.add(unit);
            }
            if (unit.isSwordsman()) {
                swordsman.add(unit);
            }
        }
        Thread calcSwordsmanPower = new Thread(() -> {swordsmanPower.addAndGet(swordsman.stream().mapToInt(Unit::getPower).sum());});
        Thread calcArcherPower = new Thread(() -> {archerPower.addAndGet(archers.stream().mapToInt(Unit::getPower).sum());});
        Thread calcMagePower = new Thread(() -> {magePower.addAndGet(mages.stream().mapToInt(Unit::getPower).sum());});
        calcMagePower.start();
        calcSwordsmanPower.start();
        calcArcherPower.start();
        calcMagePower.join();
        calcSwordsmanPower.join();
        calcArcherPower.join();
        return swordsmanPower.get()+archerPower.get()+magePower.get();
    }
}
