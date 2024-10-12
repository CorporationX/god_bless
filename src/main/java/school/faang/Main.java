package school.faang;

import school.faang.character.classes.Archer;
import school.faang.character.classes.Warrior;

public class Main {
    public static void main(String[] args) {
        Warrior styu = new Warrior("Styu");
        Archer dog = new Archer("Big Dog");

        styu.attack(dog);

        dog.attack(styu);
        dog.attack(styu);
        dog.attack(styu);

        System.out.println(styu.getName() +  " - " + styu.getHealth() + " hp");
        System.out.println(dog.getName() + " - " + dog.getHealth() + " hp");
    }
}
