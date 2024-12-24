package school.faang.task_43808;

public abstract class Character {
    protected String name;
    protected Integer power;
    protected Integer dexterity;
    protected Integer intelligence;
    protected Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public abstract void attack(Character player1);
}