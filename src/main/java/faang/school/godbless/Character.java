package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class Character {
    String name;
    private int force, dexterity, intelligence, health = 100;

    Character(String name) {
        this.name = name;
    }


    Character(int dexterity, int intelligence) {
        setDexterity(dexterity);
        setIntelligence(intelligence);
    }


    abstract public Character attack(Character hero);
}


class Warrior extends Character {


    Warrior(String name) {
        super(name);
        setForce(10);
        setDexterity(5);
        setIntelligence(3);
    }


    @Override
    public Character attack(Character hero) {
        hero.setHealth(hero.getHealth() - 10);
        return hero;
    }
}


class Archer extends Character {
    Archer(String name) {
        super(name);
        setForce(3);
        setDexterity(10);
        setIntelligence(5);
    }

    @Override
    public Character attack(Character hero) {
        hero.setHealth(hero.getHealth() - 10);
        return hero;
    }
}

