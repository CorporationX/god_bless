package faang.school.godbless.task18803;

import lombok.ToString;

@ToString
public abstract class Character {
    public String name;
    public Integer power;
    public Integer dexterity;
    public Integer intelligence;
    public Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character character);

}
