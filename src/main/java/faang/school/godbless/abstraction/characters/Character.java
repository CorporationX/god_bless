package faang.school.godbless.abstraction.characters;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.random.RandomGenerator;

@Getter
@Setter
@NonNull
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health = 100;
    private RandomGenerator generator = RandomGenerator.getDefault();

    public Character(String name) {
        this.name = name;
    }

    protected abstract int getAttackPower();

    public void attack(Character character) {
        System.out.printf("%s -> %s -> ", this.getName(), character.getName());
        randomDamage(character);
        crit(character);
        System.out.printf(" | %-3d |\n", character.getHealth());
    }

    protected void randomDamage(Character character) {
        int damage = getAttackPower() + generator.nextInt(-5, 5);
        character.setHealth(health - damage);
        System.out.printf("%-7d", damage);
    }

    protected void crit(Character character) {
        int percent = 15;
        int random = generator.nextInt(0, 100);
        int criticalStrike = generator.nextInt(20, 40);
        if (random <= percent) {
            character.setHealth(health - criticalStrike);
            System.out.printf("\b\b\b\b\b + %d", criticalStrike);
        }
    }
}
