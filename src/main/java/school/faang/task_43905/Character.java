package school.faang.task_43905;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

    public void applyDamage(Character target, int damage) {
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth - damage);

        if (damage >= targetHealth) {
            System.out.printf("%s атакует %s и наносит %d урона, убивая в битве.%n",
                    this.getName(), target.getName(), damage);
        } else {
            System.out.printf("%s атакует %s и наносит %d урона. Здоровье %s: %d%n",
                    this.getName(), target.getName(), damage, target.getName(), target.getHealth());
        }
    }
}
