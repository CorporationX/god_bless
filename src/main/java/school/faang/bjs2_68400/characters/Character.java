package school.faang.bjs2_68400.characters;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private static final int DEFAULT_STRENGTH = 5;
    private static final int DEFAULT_AGILITY = 5;
    private static final int DEFAULT_INTELLIGENCE = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = 100;

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setHealthWhenHit(int hitpoint) {
        this.health = Math.max(this.health - hitpoint, 0);
    }

    protected Character(String name) {
        this.setName(name);
        this.setStrength(DEFAULT_STRENGTH);
        this.setAgility(DEFAULT_AGILITY);
        this.setIntelligence(DEFAULT_INTELLIGENCE);
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.setName(name);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
    }

    public abstract void attack(Character opponent);

}
