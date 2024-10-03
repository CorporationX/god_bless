package school.faang;

import school.faang.heroes.Archer;
import school.faang.heroes.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ivan");
        Archer archer = new Archer("Sergey");

        System.out.println("До боя:");
        warrior.showHealth();
        archer.showHealth();
        System.out.println("Бой:");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("После боя:");
        warrior.showHealth();
        archer.showHealth();
    }
}