package school.faang.Abstract;

import java.util.Random;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 10, 10);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() - this.getStrength());
        System.out.println("Character attack : " + this.getName() + " has attacked " +   character.getName() + " - "+ "still has " + "Helth : " + character.getHealth());
    }
}
//The warrior has attacked and the enemy still has