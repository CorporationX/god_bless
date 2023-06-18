package faang.school.godbless.abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(String.format("%s(класс %s) атакует %s(класс %s)", this.getName(),
                this.getClass().getSimpleName(), enemy.getName(), enemy.getClass().getSimpleName()));
        int newHealth = enemy.getHealth() - this.getStrength();
        enemy.setHealth(newHealth);
    }
}
