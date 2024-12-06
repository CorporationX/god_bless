package school.faang.bjs243816;

import lombok.Data;

@Data
public abstract class Character {
    private final String name;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private int health = 100;

    public abstract void attack(Character character);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("%s Health: %d", name, health);
    }
}
