package faang.school.godbless.BJS2_4215;

public class Taks4 {
    public static void main(String[] args) {

        Character warrior = new Warrior("Knighter");
        Character archer = new Archer("Boower");

        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(archer);
        System.out.println(warrior);
    }
}

abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private  int health= 100;

    public Character(String name){
        this.name = name;
    }
    public Character(int strength, int agility, int intellect){
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }
    public String getName() { return name; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public abstract void attack(Character opponent);

}