package faang.school.godbless.BJS2_1055;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(List.of(new Archer(25), new Swordsman(40), new Mage(50), new Archer(25), new Swordsman(40), new Mage(50)));
        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
