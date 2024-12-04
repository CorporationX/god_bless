package school.faang;

public abstract class Character {
    private String name;
    private int power;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(){

    }

    public Character(String name, int power, int agility, int intellect){

    }

    public void setHealth(int attack) {
        this.health -= attack;
    }

    public int GetPower() {
        return this.power;
    }

    public int GetAgility() {
        return this.agility;
    }

    public abstract void attack(Character character);
}
