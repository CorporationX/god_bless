package school.faang.bjs2_85543;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int FULL_HP_BY_DEFAULT = 100;
    private static final int PARAMETER_STRENGTH_BY_DEFAULT = 5;
    private static final int PARAMETER_AGILITY_BY_DEFAULT = 5;
    private static final int PARAMETER_INTELLIGENCE_BY_DEFAULT = 5;
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
        this.strength = PARAMETER_STRENGTH_BY_DEFAULT;
        this.intelligence = PARAMETER_INTELLIGENCE_BY_DEFAULT;
        this.agility = PARAMETER_AGILITY_BY_DEFAULT;
    }

    public abstract void attack(Character opponent);

    public void getHeroAttackDamage(Character opponent, int damage) {
        System.out.printf("Damage caused by %s in size %d by hero %s \n",
                this.getName(), this.getStrength(), opponent.getName());

        int health = opponent.getHealth() - damage;

        if (health <= 0) {
            opponent.setHealth(0);
            System.out.printf("Hero %s is died \n", opponent.getName());
            return;
        }
        opponent.setHealth(health);
        System.out.printf("Hero %s have %d hp \n", opponent.getName(), opponent.getHealth());
    }

}
