package faang.school.godbless.abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(String.format("%s(класс %s) атакует %s(класс %s)", this.getName(),
                this.getClass().getSimpleName(), enemy.getName(), enemy.getClass().getSimpleName()));
        int newHealth = enemy.getHealth() - this.getAgility();
        enemy.setHealth(newHealth);
    }
}
