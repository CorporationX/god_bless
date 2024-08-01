package faang.school.godbless;

public abstract class Character {
    String name;
    int power;
    int dexterity;
    int intelligence;
    int health = 100;

    public Character(){
        this.name = name;
    }
    public Character(int power, int dexterity, int intelligence, int health){
        this.power = power;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = health;
    }
    abstract void attack(Character enemy);
}
