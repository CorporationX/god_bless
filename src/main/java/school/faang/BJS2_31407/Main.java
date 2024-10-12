package school.faang.BJS2_31407;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Character warrior = new Warrior("Mark");
        Character archer = new Archer("Andrei");

        warrior.attack(archer);
        archer.attack(warrior);

        List<Character> characters = List.of(new Warrior("warrior"), new Archer("archer"));
        Character target = new Warrior("target");
        characters.forEach(character -> character.attack(target));

        System.out.println(archer.getName() + " to have " + archer.getHealth() + " health.");
        System.out.println(warrior.getName() + " to have " + warrior.getHealth() + " health.");

        System.out.println(target.getName() + " to have " + target.getHealth() + " health.");
    }

}

