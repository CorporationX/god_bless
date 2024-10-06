package school.faang.main_code_abstraction;

import school.faang.main_code_abstraction.*;
public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Achiles", 10, 5, 3);
        Archer archer = new Archer("Sin_peleya", 3, 10, 5);

        warrior.attack(archer);
        archer.attack(warrior);
        warrior.attack(archer);

        System.out.println(warrior);
        System.out.println(archer);
    }
}