package school.faang.task_43924;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.power = 3;
        this.agility = 10;
        this.intelligence = 5;
    }

    @Override
    void attack(Character character) {
        int healthDamage  = healthPoint - agility;
        System.out.println(healthDamage);
    }
}
