package school.faang.basic.abstraction.characters;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public abstract class Character {

    private static final List<String> DAMAGE_LINES = List.of("AAAY!", "AGH!", "UPHHH!", "KHEH!");
    private static final int DEFAULT_HEALTH = 100;

    @Setter
    protected int strength;
    @Setter
    protected int agility;
    @Setter
    protected int intelligence;
    private final String name;
    private int health;
    private boolean isDead;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
        this.isDead = false;
    }

    public void praise() {
        log.info("{} screams: VICTORY!", this);
    }

    public void hitOpponent(Character opponent) {
        log.info("{} strikes {}", this, opponent);
        opponent.takeDamage(getAttackDamage());
    }

    public void takeDamage(int damage) {
        if (damage >= health) {
            isDead = true;
            health = 0;
            log.info("{} - is dead!", name);
            return;
        }
        health -= damage;
        log.info("{} screams {}", this, Randomizer.pickRandomMember(DAMAGE_LINES));
    }

    protected abstract int getAttackDamage();

    @Override
    public String toString() {
        return "%s[%d]".formatted(name, health);
    }
}