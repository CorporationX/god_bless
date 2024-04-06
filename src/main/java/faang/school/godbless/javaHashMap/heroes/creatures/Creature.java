package faang.school.godbless.javaHashMap.heroes.creatures;

import lombok.Data;

@Data
public abstract class Creature {
    private String name;
    private int lvl;
    private int manaCost; // the manaCost of summoning the creature
    private int attack;
    private int defence;
    private int speed;

    public int getDamage() {
        return attack;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        this.name = name;
    }
}
