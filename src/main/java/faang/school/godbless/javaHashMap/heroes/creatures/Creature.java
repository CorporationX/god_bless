package faang.school.godbless.javaHashMap.heroes.creatures;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@EqualsAndHashCode
public abstract class Creature {
    private String name;
    private int lvl;
    private int hp;
    private int attack;
    private int defence;
    private int speed;
    private int quantity;

    public int getDamage() {
        return attack;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        this.name = name;
    }
}
