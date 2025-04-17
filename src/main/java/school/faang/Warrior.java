package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {

    public static final int MAX_STRENGTH = 10;
    public static final int MAX_AGILITY = 5;
    public static final int MAX_INTELLECT = 3;

    protected Warrior(String name) {
        super(name, MAX_STRENGTH, MAX_AGILITY, MAX_INTELLECT);
    }

    public void attack(Character opponent) {

        opponent.reduceHealth(this.getStrength());
        log.info("{} атакует {} и наносит {} урона", this.getName(), opponent.getName(), MAX_STRENGTH);
    }
}