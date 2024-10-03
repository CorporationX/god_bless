package school.faang;

import school.faang.heroes.Archer;
import school.faang.heroes.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ivan");
        Archer archer = new Archer("Sergey");

        System.out.printf("Здоровье %s %d\n", archer.getName(), archer.getHealth());
        System.out.printf("Здоровье %s %d\n", warrior.getName(), warrior.getHealth());
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.printf("Здоровье %s %d\n", archer.getName(), archer.getHealth());
        System.out.printf("Здоровье %s %d\n", warrior.getName(), warrior.getHealth());
    }
}