package faang.school.godbless.task_1.Creature;


import lombok.Getter;

@Getter
public abstract class Creature {
    protected String name;
    protected int health;
    protected int level;
    protected int attack;
    protected int defence;
    protected int speed;


    public int getDamage() {
        return (attack * level) + speed - defence;
    }
}
