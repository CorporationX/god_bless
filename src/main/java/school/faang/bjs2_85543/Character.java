package school.faang.bjs2_85543;

import lombok.Getter;
import lombok.Setter;

import static school.faang.bjs2_85543.HeroesCharacteristics.CHARACTER_AGILITY_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.CHARACTER_INTELLIGENCE_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.CHARACTER_STRENGTH_BY_DEFAULT;
import static school.faang.bjs2_85543.HeroesCharacteristics.FULL_HP_BY_DEFAULT;

@Getter
@Setter
public abstract class Character {
    private int health = FULL_HP_BY_DEFAULT;
    private String name;
    private final int strength;
    private final int agility;
    private final int intelligence;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
        this.strength = CHARACTER_STRENGTH_BY_DEFAULT;
        this.intelligence = CHARACTER_INTELLIGENCE_BY_DEFAULT;
        this.agility = CHARACTER_AGILITY_BY_DEFAULT;
    }

    public abstract void attack(Character opponent);

    public void reduceHealth(Character opponent, int damage) {
        System.out.printf("Damage caused by %s in size %d by hero %s \n",
                this.getName(), damage, opponent.getName());

        int health = opponent.getHealth() - damage;
        opponent.setHealth(Math.max(health, 0));
        if (opponent.getHealth() == 0) {
            System.out.printf("Hero %s is died \n", opponent.getName());
        } else {
            System.out.printf("Hero %s have %d hp \n", opponent.getName(), opponent.getHealth());
        }
    }

}
