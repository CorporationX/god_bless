package school.faang.sprint1.task_bjs243889;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private static final Integer DEFAULT_HEALTH = 100;

    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intellect;
    private Integer health = DEFAULT_HEALTH;

    public abstract void attack(Character character);

    public void receiveDamage(Integer damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным.");
        }
        this.health = Math.max(this.health - damage, 0);
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

}
