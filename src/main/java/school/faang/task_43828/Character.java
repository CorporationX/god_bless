package school.faang.task_43828;

import lombok.Getter;

@Getter
public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void takeDamage(int damage) {
        if (health > 0) {
            health = health - damage;
            if (health <= 0) {
                health = 0;
                System.out.println(name + " убит!");
            }
        }
    }

    public abstract void attack(Character character);
}
