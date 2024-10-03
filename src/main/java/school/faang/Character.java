package school.faang;

import lombok.Getter;

@Getter
abstract class Character {
    private String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intellect;
    protected Integer health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer agility, Integer intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
        this.health = 100;
    }

    protected abstract Character attack(Character character);
}
