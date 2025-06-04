package school.faang.abstraction79174;

import lombok.Data;

@Data
abstract class Character {
    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.dexterity = 5;
        this.intelligence = 5;
    }

    public abstract void attack(Character opponent);

    public static void checkHealth(Character character) {
        if (character.getHealth() <= 0) {
            character.setHealth(0);
            System.out.println("Персонаж " + character.getName() + " погиб");
        }
    }
}
