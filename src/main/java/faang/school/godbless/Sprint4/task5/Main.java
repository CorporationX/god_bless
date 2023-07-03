package faang.school.godbless.Sprint4.task5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(Arrays.asList
                (new Archer("Archers", 25, 4),
                        new Swordsman("Swordsmen", 40, 2),
                        new Mage("Mages", 50, 2)));

        String totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
