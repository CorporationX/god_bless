package Task3;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public abstract class Character {
    private final String name;
    protected int power;
    protected int agility;
    protected int intellect;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

    public boolean  willSurvive(int damage) {
        return this.health > damage;
    }

    protected static void dealDamage(@NotNull Character enemy, int damage) {
        if (enemy. willSurvive(damage)) {
            enemy.health -= damage;
        } else {
            enemy.health = 0;
            System.out.println("Enemy is dead!");
        }
    }
}
