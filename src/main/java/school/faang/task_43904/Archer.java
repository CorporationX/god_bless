package school.faang.task_43904;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        health -= enemy.dexterity;
        enemy.health -= dexterity;

        System.out.println("Attack! My health = " + health);
        System.out.println("Contrattack! Enemy health = " + enemy.health);
    }
}
