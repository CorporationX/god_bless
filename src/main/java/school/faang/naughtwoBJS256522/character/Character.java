package school.faang.naughtwoBJS256522.character;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Character {
    private String name;
    @Setter private int strength; //сила
    @Setter private int agility; //ловкость
    @Setter private int intelligence; //интеллект
    private int health = 100;

    private static final int DEFAULT_SKILL_VALUE = 5;

    public Character(String name) {
        this.name = name;
        this.strength = DEFAULT_SKILL_VALUE;
        this.agility = DEFAULT_SKILL_VALUE;
        this.intelligence = DEFAULT_SKILL_VALUE;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println(this.getName() + " is dead. The character cannot attack anymore");
        }
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Введены неверные данные");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Character: name- %s, strength- %d, agility- %d, intelligence- %d, health- %d.",
                this.getName(), this.getStrength(), this.getAgility(), this.getIntelligence(), this.getHealth());
    }

    public void attack(Character opponent) {
        if (opponent.health < 0) {
            opponent.health = 0;
        }
    }
}
