package faang.school.godbless.abstractTask;

public class Warrior extends  Character{
    public Warrior(String name) {
        this.name = name;
        this.strength = 10;
        this.agility = 5;
        this.intelligence = 3;
    }


    @Override
    public void attack(Character target) {
        int targetHealth = target.health - this.strength;
        System.out.println("Warrior health" +  this.health);
        System.out.println("Target health" +  targetHealth);
    }
}
