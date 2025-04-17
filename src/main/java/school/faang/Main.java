package school.faang;

import school.faang.rpg.Archer;
import school.faang.rpg.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Adolf");
        Archer archer = new Archer("Eva");
        warrior.attack(archer);
        archer.attack(warrior);
    }
}
