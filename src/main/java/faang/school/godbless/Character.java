package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;
    public Character(String name){
        this.name = name;
    }
    public Character(String name, int strength, int agility, int intellect){
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }
    public abstract void attack (Character target);
}
class Warrior extends Character{
    public Warrior (String name){
        super(name, 10, 5, 3);
    }
    @Override
    public void attack(Character target) {
        target.health -= this.getStrength();

    }
}
class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character target) {
        target.health -= this.getAgility();
    }
}
