package bjs2_85596;

import lombok.Getter;

@Getter
public class Archer extends Character {

    private static final int ARCHER_AGILITY = 10;
    private static final int ARCHER_STRENGTH = 3;
    private static final int ARCHER_INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, ARCHER_AGILITY, ARCHER_STRENGTH, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        int damage = this.agility;
        opponent.reduceHealth(damage);
        System.out.println(String.format("%s атакует %s, и наносит %d урона, оставшееся здоровье: %d",
                this.name, opponent.name, damage, opponent.health));
    }
}
