package school.faang.bjs2_85531;


import lombok.Getter;
import lombok.Setter;

import static school.faang.bjs2_85531.HeroCharacter.CHARACTER_AGILITY;
import static school.faang.bjs2_85531.HeroCharacter.CHARACTER_INTELLIGENCE;
import static school.faang.bjs2_85531.HeroCharacter.CHARACTER_STRENGTH;
import static school.faang.bjs2_85531.HeroCharacter.HEALTH;

@Getter
@Setter
public abstract class Character {
    private int health = HEALTH;
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;

    public Character(String name) {
        this.name = name;
        this.strength = CHARACTER_STRENGTH;
        this.intelligence = CHARACTER_INTELLIGENCE;
        this.agility = CHARACTER_AGILITY;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character opponent) {
        if (opponent.getHealth() > 0) {
            int damage = this.getHeroAttackDamage();
            int newHealth = Math.max(0, opponent.getHealth() - damage);
            opponent.setHealth(newHealth);
            if (opponent.getHealth() <= 0) {
                System.out.println(opponent.getName() + " повержен");
                return;
            }
            System.out.printf("%s HP %d \n", opponent.getName(), opponent.getHealth());
        }
    }

    public abstract int getHeroAttackDamage();

}
