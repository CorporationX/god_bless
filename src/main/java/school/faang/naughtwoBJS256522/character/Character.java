package school.faang.naughtwoBJS256522.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength; //сила
    private int agility; //ловкость
    private int intelligence; //интеллект
    private int health = 100;

    private int defaultSkillValue = 5; //не могу дать название в верхнем регистре, ругается гит

    public Character(String name) {
        this.name = name;
        this.strength = defaultSkillValue;
        this.agility = defaultSkillValue;
        this.intelligence = defaultSkillValue;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return String.format("Character: name- %s, strength- %d, agility- %d, intelligence- %d, health- %d.",
                this.getName(), this.getStrength(), this.getAgility(), this.getIntelligence(), this.getHealth());
    }

    public void attack(Character opponent) {
        if (this.health <= 0) {
            System.out.println(this.getName() + " is dead. The character cannot attack anymore");
        }
        if (opponent.health < 0) {
            opponent.health = 0;
        }
    }
}
