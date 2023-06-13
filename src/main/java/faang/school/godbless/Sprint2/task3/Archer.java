package faang.school.godbless.Sprint2.task3;

public class Archer extends Character {
    public Archer(String name) {
        super(name);
        this.setPower(3);
        this.setAgility(10);
        this.setIntelligence(5);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.health - this.agility);
        System.out.println(this.name + " attacks -> " + enemy.name + "\n" +
                enemy.name + " has " + enemy.health + " health points left");
    }
}
