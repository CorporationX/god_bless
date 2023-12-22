package faang.school.godbless.BJS2_1120;

import java.util.ArrayList;
import java.util.List;

public class Army {
    public List<Unit> army = new ArrayList<>();
    int totalPower = 0;

    public void addArmy(Unit unit) {
        army.add(unit);
    }

    public void calculateTotalPower() {
        Thread thread = new Thread(() -> {
            for (Unit unit : army) {
                totalPower += unit.getPower();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Поток прерван" + thread.toString());
        }

        for (Unit unit : army) {
            SumPower sum = new SumPower(unit);
            sum.start();
            try {
                sum.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток прерван" + sum.toString());
            }
        }
    }

    public static void main(String[] args) {
        Army army = new Army();
        army.addArmy(new Archer(25));
        army.addArmy(new Swordsman(40));
        army.addArmy(new Mage(50));
        army.addArmy(new Mage(20));

        army.calculateTotalPower();
        System.out.println("Total army power: "
                + army.totalPower);

        System.out.println(SumPower.getArcherPower());
        System.out.println(SumPower.getSwordsmanPower());
        System.out.println(SumPower.getMagePower());
    }
}

