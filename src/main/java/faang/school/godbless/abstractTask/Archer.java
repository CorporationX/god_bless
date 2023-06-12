package faang.school.godbless.abstractTask;

public class Archer extends Character {
    public Archer(String name) {
        this.name = name;
        this.strength = 3;
        this.agility = 10;
        this.intelligence = 5;
    }


    @Override
    public void attack(Character target) {
        int targetHealth = target.health - this.agility;
        System.out.println("Archer health" +  this.health);
        System.out.println("Target health" +  targetHealth);
    }

}
