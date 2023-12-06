package faang.school;

import abstraction.Archer;
import abstraction.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("war");
        Archer archer = new Archer("arch");
        System.out.println(warrior);
        archer.attack(warrior);
        System.out.println(warrior);
    }
}
