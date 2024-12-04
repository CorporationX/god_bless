package school.faang.task_43802;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healthPoints = 100;
    private boolean isAlive = true;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void attack(Character target) {
        if (!this.isAlive) {
            System.out.println("не могу атаковать - я мертв");
            return;
        }

        if (!target.isAlive()) {
            System.out.println("не могу атаковать - " + target.name + " кормит червей");
            return;
        }

        target.healthPoints -= this.strength;
        System.out.println(this.name + " атакует " + target.name + " и наносит " + this.strength + " урона");
        System.out.println(target.name + " поймал маслину, у него осталось " + target.healthPoints + " HP");

        if (target.healthPoints <= 0) {
            target.isAlive = false;
            target.healthPoints = 0;
            System.out.println(target.name + " отправился в Вальгаллу");
        }
    }
}


