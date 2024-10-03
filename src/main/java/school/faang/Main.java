package school.faang;

import school.faang.heroes.Archer;
import school.faang.heroes.Character;
import school.faang.heroes.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ivan");
        Archer archer = new Archer("Sergey");
        List<Character> heroes = List.of(warrior, archer);


        System.out.println("До боя:");
        heroes.forEach(Character::showHealth);
        System.out.println("Бой:");
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("После боя:");
        heroes.forEach(Character::showHealth);
    }
}