package school.faang.abstraction;

import school.faang.abstraction.models.Archer;
import school.faang.abstraction.models.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Voin");
        Archer archer1 = new Archer("Strelok");

        System.out.println("Start fight");

        warrior1.attack(archer1);
        archer1.attack(warrior1);
        archer1.attack(warrior1);
        warrior1.attack(archer1);

    }
}
