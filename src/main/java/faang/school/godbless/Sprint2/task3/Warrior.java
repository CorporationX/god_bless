package faang.school.godbless.Sprint2.task3;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name);
        this.setPower(10);
        this.setAgility(5);
        this.setIntelligence(3);
    }

    @Override
    public void attack(Character enemy) {
        enemy.setHealth(enemy.health - this.power);
        System.out.println(this.name + " attacks -> " + enemy.name + "\n" +
                enemy.name + " has " + enemy.health + " health points left");
    }
}
