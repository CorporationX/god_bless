package faang.school.godbless.creation;

import lombok.Data;

@Data
public abstract class Creature {
    // Изменить все поля на private
    private String name;
    private int level;
    protected int speed;
    protected int attack;
    protected int protection;

    public Creature(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getDamage() {
        int damage = attack;
        return damage;
    }
}
