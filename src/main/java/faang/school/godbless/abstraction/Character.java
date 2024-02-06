package faang.school.godbless.abstraction;

public abstract class Character {
    //Имя;
    //Сила;
    //Ловкость;
    //Интеллект;
    //Здоровье. У всех персонажей по умолчанию 100.

    protected String name;
    protected int power;
    protected int skill;
    protected int intelligence;
    protected int hp = 100;

    public Character(String name, int power, int skill, int intelligence) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);


}
