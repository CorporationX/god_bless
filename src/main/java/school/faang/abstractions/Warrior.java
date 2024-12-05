package school.faang.abstractions;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("Warrior attack");
        enemy.hp -= strength;
    }
}
