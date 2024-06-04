package faang.school.godbless.task3;

import lombok.ToString;

@ToString
abstract public class Character {

    protected String name;

    protected int power;

    protected int dexterity;

    protected int intelligence;

    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int dexterity, int intelligence) {
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void attack(Character character) {}


}
