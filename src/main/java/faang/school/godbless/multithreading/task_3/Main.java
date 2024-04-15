package faang.school.godbless.multithreading.task_3;

import faang.school.godbless.multithreading.task_3.model.Archer;
import faang.school.godbless.multithreading.task_3.model.Army;
import faang.school.godbless.multithreading.task_3.model.Mage;
import faang.school.godbless.multithreading.task_3.model.Swordsman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        int totalPower = army.calculateTotalPower();
        System.out.println("total power of army is: " + totalPower);
    }
}