package faang.school.godbless.army_of_heroes;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Army army = new Army(Arrays.asList
                (new Archer("Archers", 35, 3),
                        new Swordsman("Swordsmen", 35, 4),
                        new Mage("Mages", 70, 3)));

        System.out.println(army.calculateTotalPower());
    }
}
