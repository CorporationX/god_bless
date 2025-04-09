package school.faang.basic.abstraction.characters;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.List;

@Slf4j
@Getter
public abstract class Character {

    private static final List<String> DAMAGE_LINES = List.of("AAAY!", "AGH!", "UPHHH!", "KHEH!");

    protected int strength;
    protected int agility;
    protected int intelligence;
    private final String name;
    private int health = 100;
    private boolean isDead = false;

    public Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character target);

    public void hitOpponent(Character opponent){
        log.info(this.name.concat(" strikes ").concat(opponent.getName()));
        attack(opponent);
    }

    public void praise() {
        log.info(name.concat(" screams: VICTORY!"));
    }

    protected void takeDamage(int damage) {
        if(damage < health) {
            health -= damage;
            log.info(name.concat(" screams: ").concat(DAMAGE_LINES.get(new SecureRandom().nextInt(0, DAMAGE_LINES.size()))));
        } else {
            isDead = true;
            health = 0;
            log.info(name.concat(" - is dead!"));
        }
    }
}