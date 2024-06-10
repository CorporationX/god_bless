package faang.school.godbless.abstractionAbstraction;

public abstract class Character {

    private String name;
    //сила
    private int power;
    //ловкость
    private int skill;
    //интеллект
    private int mind;
    //здоровье
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int skill, int mind) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.mind = mind;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return this.power;
    }

    public int getSkill() {
        return this.skill;
    }

    public abstract void attach(Character character);
}
