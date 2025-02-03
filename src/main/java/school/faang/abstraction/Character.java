package school.faang.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
abstract class Character {
    private final String name;
    private final Integer strength;
    private final Integer agility;
    private final Integer intelligence;
    @Setter
    private Integer health = 100;

    Character(String name, Integer strength, Integer agility, Integer intelligence) {
        checkName(name);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    Character(String name) {
        checkName(name);
        this.name = name;
        strength = agility = intelligence = 5;
    }

    abstract void attack(Character opponent);

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else {
            health = 0;
            return false;
        }
    }

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is missing");
        }
    }
}
