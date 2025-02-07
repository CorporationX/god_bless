package school.faang;

import school.faang.rpggame.Archer;
import school.faang.rpggame.Warrior;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Arch");
        Warrior warrior = new Warrior("Warrior");
        warrior.attack(archer);

    }
}
