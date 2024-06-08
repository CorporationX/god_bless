package BJS2_7733;

public abstract class Character {
    public String name;
    public int power, skill, intellect;
    public int hp = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(int power, int skill, int intellect) {
        this.power = power;
        this.skill = skill;
        this.intellect = intellect;
    }


    public abstract void attack(Character character);
}


