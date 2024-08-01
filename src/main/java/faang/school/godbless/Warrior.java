package faang.school.godbless;

public class Warrior extends Character {

    public Warrior(String name){
        super();
        this.name = name;
        this.power = 10;
        this.dexterity = 5;
        this.intelligence = 3;
    }

    @Override
    void attack(Character enemy) {
        enemy.health -= power;
        System.out.println("Current " + enemy.name + " health: " + enemy.health);
    }
}