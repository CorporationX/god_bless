package school.faang.bjs2_58508;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Character {

    protected final String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this(name, 5, 5, 5);
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character opponent);

    protected void reduceHealth(Character opponent, int damage) {
        opponent.setHealth(Math.max(opponent.getHealth() - damage, 0));
        if (opponent.getHealth() == 0) {
            System.out.println(opponent.getName() + " don't have enough health! He's lose!");
        }
    }


}
