package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    protected int strength;
    protected int dexterity;
    protected int intellect;
    protected int hp = 100;
    public Character (String name) {
        this.name = name;
    }
    public abstract void attack (Character target);
}
