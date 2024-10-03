package school.faang;

abstract class Character {
    private String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intellect;
    protected Integer health = 100;

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
    abstract protected Character attack(Character character);
}
