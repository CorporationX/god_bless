package faang.school.godbless.BJS211012;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(List.of(new Archer(20), new Swordsman(20), new Mage(30)
                , new Archer(30), new Swordsman(30), new Mage(40), new Archer(30)
                , new Swordsman(30), new Mage(40)));

        int totalPower = army.calculateTotalPower();
        System.out.println("total power = " + totalPower);
    }
}
