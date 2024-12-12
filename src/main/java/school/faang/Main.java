package school.faang;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Uruk-hai");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        System.out.println(archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getHealth());

    }
}
