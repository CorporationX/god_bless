package bjs2_85596;

import lombok.Getter;

@Getter
public class Warrior extends Character {

    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_AGILITY, WARRIOR_STRENGTH, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.strength;
        opponent.reduceHealth(damage);
        System.out.println(String.format("%s атакует %s, и наносит %d урона, оставшееся здоровье: %d",
                this.name, opponent.name, damage, opponent.health));
    }
}

