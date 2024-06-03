package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer power;
    private Integer Dexterity;
    private Integer Intelligence;
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(Integer power, Integer dexterity, Integer intelligence) {
        this.power = power;
        Dexterity = dexterity;
        Intelligence = intelligence;
    }

    public abstract void attack(Character character);
}
