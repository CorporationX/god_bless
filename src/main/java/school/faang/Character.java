package school.faang;

public abstract class Character {

    int health;
    String name;
    int power;
    int skill;
    int intellect;

    public Character(String name) {
        this.name = name;
        this.health = 100;
    }

    public Character(String name, int power, int skill, int intellect) {
        this.name = name;
        this.power = power;
        this.skill = skill;
        this.intellect = intellect;
        this.health = 100;
    }

    abstract void attack(Character character);
}
