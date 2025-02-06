package school.faang.task_56490;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Character {
    private static final int DEFAULT_HEALTH = 100;
    private static final int BASED_VALUE = 5;

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int hp;

    public Character(String name) {
        this(name, BASED_VALUE, BASED_VALUE, BASED_VALUE);
        this.hp = DEFAULT_HEALTH;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.hp = DEFAULT_HEALTH;
    }

    public abstract void attack(Character opponent);

    protected void reduceHp(Character character, int damage) {
        if (hp > 0) {
            character.setHp(character.getHp() - damage);
            if (hp <= 0) {
                hp = 0;
            }
        }
        System.out.println(this.name + " : " + this.hp + " HP" + "\t"
                + character.getName() + " : " + character.getHp() + " HP\n");
    }
}
