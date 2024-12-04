package school.faang.bjs243845;

import lombok.Getter;

@Getter
public abstract class Character {

    private static final Integer DEFAULT_HEALTH = 100;
    private static final Integer MIN_STRENGTH = 1;
    private static final Integer MIN_AGILITY = 1;
    private static final Integer MIN_INTELLIGENCE = 1;
    private static final Integer MIN_HEALTH = 1;

    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Integer health;

    public Character(String name) {
        setName(name);
        setHealth(DEFAULT_HEALTH);
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        setName(name);
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
        setHealth(DEFAULT_HEALTH);
    }

    public abstract void attack(Character character);


    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is must be not empty");
        }
        this.name = name;
    }

    public void setHealth(Integer health) {
        if (health < MIN_HEALTH) {
            throw new IllegalArgumentException("health must me > 0");
        }
        this.health = health;
    }

    public void setStrength(Integer strength) {
        if (strength < MIN_STRENGTH) {
            throw new IllegalArgumentException("strength must me > 0");
        }
        this.strength = strength;
    }

    public void setAgility(Integer agility) {
        if (agility < MIN_AGILITY) {
            throw new IllegalArgumentException("agility must me > 0");
        }
        this.agility = agility;
    }

    public void setIntelligence(Integer intelligence) {
        if (intelligence < MIN_INTELLIGENCE) {
            throw new IllegalArgumentException("intelligence must me > 0");
        }
        this.intelligence = intelligence;
    }


}
