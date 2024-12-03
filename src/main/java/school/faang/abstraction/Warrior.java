package school.faang.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        // Установка стандартных значений для Warrior
        this.strength = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name);
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        target.health -= this.strength;
    }
}
