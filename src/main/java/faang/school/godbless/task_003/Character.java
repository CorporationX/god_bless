package faang.school.godbless.task_003;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public abstract class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character enemy);

    /**
     * Получение урона
     *
     * @param damage - входящий урон.
     */
    public void takeDamage(int damage) {

        // Если здоровье станет отрицательным
        if (this.health - damage <= 0) {
            this.health = 0;
            return;
        }

        this.health -= damage;
    }
}
