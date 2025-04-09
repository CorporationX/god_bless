package school.faang.bjs2_68159;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    public Integer health = 100;

    protected Character(String name) {
        this.name = name;
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
    }

    protected Character(
        String name,
        Integer strength,
        Integer agility,
        Integer intelligence
    ) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character opponent);

    protected void receiveDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }

    protected boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s {STR: %d, AG: %d, INT: %d, HP: %d}",
            name, strength, agility, intelligence, health
        );
    }
}
