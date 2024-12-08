package school.faang.task_43924;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name);
        this.power = 10;
        this.agility = 5;
        this.intelligence = 3;
    }

    @Override
    void attack(Character character) {
        int healthDamage = healthPoint - power;
        System.out.println(healthDamage);
    }
}

