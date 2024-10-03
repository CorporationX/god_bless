package school.faang;

public abstract class Character {

    protected String name;
    protected Integer power;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer health = 100;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, Integer power, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);
}
