package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        strength = agility = intellect = 5;
    }

    public Character(String name, int willpower, int adroitness, int intellect) {
        this.name = name;
        this.strength = willpower;
        this.agility = adroitness;
        this.intellect = intellect;
    }

    public void checkOpponentHealth(Character opponent, int injury) {

        if(opponent.health - injury < 0) {

            //System.out.println("Health can't be less 0");
            throw new IllegalArgumentException("Health can't be less 0");
        }
    }

    public abstract void attack(Character opponent);

}

class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        setStrength(10);
        setAgility(5);
        setIntellect(3);
    }

    public Warrior(String name, int willpower, int adroitness, int intellect) {
        super(name, willpower, adroitness, intellect);
    }

    @Override
    public void attack(Character opponent) {

        checkOpponentHealth(opponent, getStrength());
        opponent.setHealth(opponent.getHealth() - getStrength());
    }
}

class Archer extends Character {

    public Archer(String name) {
        super(name);
        setStrength(3);
        setAgility(10);
        setIntellect(5);
    }

    public Archer(String name, int willpower, int adroitness, int intellect) {
        super(name, willpower, adroitness, intellect);
    }

    @Override
    public void attack(Character opponent) {

        checkOpponentHealth(opponent, getAgility());
        opponent.setHealth(opponent.getHealth() - getAgility());
    }
}
