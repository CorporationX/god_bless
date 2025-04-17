package school.faang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {

    public static final int MAX_STRENGTH = 3;
    public static final int MAX_AGILITY = 10;
    public static final int MAX_INTELLECT = 5;

    protected Archer(String name) {
        super(name, MAX_STRENGTH, MAX_AGILITY, MAX_INTELLECT);
    }

    public void attack(Character opponent) {
        opponent.reduceHealth(getAgility());
        log.info("{} атакует {} и наносит {} урона", this.getName(), opponent.getName(), MAX_AGILITY);
    }
}