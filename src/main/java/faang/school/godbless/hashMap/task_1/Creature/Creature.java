package faang.school.godbless.hashMap.task_1.Creature;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class Creature {

    protected String name;
    @Setter
    protected int health;
    protected int level;
    protected int attack;
    protected int defence;
    protected int speed;


    public int getDamage(Creature creature) {
        return (creature.attack * creature.level) + creature.speed - creature.defence;
    }
}
