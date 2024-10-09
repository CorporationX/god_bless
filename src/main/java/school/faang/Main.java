package school.faang;

import school.faang.bjs2_31473.Archer;
import school.faang.bjs2_31473.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Conan");
        Archer archer = new Archer("Legolas");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}