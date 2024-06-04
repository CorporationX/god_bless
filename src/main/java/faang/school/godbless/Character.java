package faang.school.godbless;

public abstract class Character {

    private String name;
    //сила
    private Integer power;
    //ловкость
    private Integer skill;
    //интеллект
    private Integer mind;
    //здоровье
    private Integer health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer power, Integer skill, Integer mind) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.mind = mind;
    }

    public Integer getHealth() {
        return this.health = health;
    }

    public Integer setHealth(Integer health) {
        return this.health = health;
    }

    public Integer getPower() {
        return this.power;
    }

    public Integer getSkill() {
        return this.skill;
    }

    public abstract void attach(Character character);
}
