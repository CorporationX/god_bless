package faang.school.godbless.abstraction;

import lombok.Getter;

@Getter
public abstract class Character {

    protected String name;
    protected int power;
    protected int dexterity;
    protected int intelligence;
    protected int health;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int power, int dexterity, int intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public void attack(Character character) {
        System.out.println(character.name + " получил с вертушки");
    }
}
