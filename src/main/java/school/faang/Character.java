package school.faang;

abstract class Character {
    private String name;
    Integer power;
    Integer agility;

    Integer intellect;
    Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer agility, Integer intellect, Integer health) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
        this.health = health;
    }

    Character attack(Character character) {
        return character;
    }
}
