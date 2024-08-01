package faang.school.godbless;

public class Archer extends Character{
    public Archer(String name){
        super();
        this.name = name;
        this.power = 3;
        this.dexterity = 10;
        this.intelligence = 5;
    }
    @Override
    void attack(Character enemy){
        enemy.health -= dexterity;
        System.out.println("Current " + enemy.name + " health: " + enemy.health);
    }
}

