package school.faang.bjs2_79203_abstraction;

import school.faang.bjs2_79203_abstraction.archers.Archer;
import school.faang.bjs2_79203_abstraction.warriors.Warrior;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Громила");
        Character archer = new Archer("Точный глаз");

        System.out.println(warrior);
        System.out.println(archer);

        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("\nПосле атаки:");
        System.out.println(warrior);
        System.out.println(archer);
    }
}