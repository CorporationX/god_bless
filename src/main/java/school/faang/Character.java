package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Character {
    private String name;
    private int health;
    private int strength;
    private int agility;
    private int mind;

    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    protected abstract void attack(Character target);
}
