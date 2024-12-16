package faang.school.godbless.sprint_1.task_43932;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Character {
    private final String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void receiveDamage(int damage) {
        int characterHealthAfterAttack = this.health - damage;
        if (characterHealthAfterAttack <= 0) {
            this.health = 0;
            System.out.println("Противник " + this + " мёртв!");
            return;
        }
        this.health = characterHealthAfterAttack;
    }

    public abstract void attack(Character character);
}
