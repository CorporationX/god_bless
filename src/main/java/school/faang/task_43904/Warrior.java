package school.faang.task_43904;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        health -= enemy.power;
        enemy.health -= power;

        System.out.println("Attack! My health = " + health);
        System.out.println("Contrattack! Enemy health = " + enemy.health);
    }
}
