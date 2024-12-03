package school.faang.abstractions;

public class Warrior extends Character {
    private int strength = 10;
    private int dexterity = 5;
    private int intelligence = 3;

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("Warrior attack");
        enemy.hp -= strength;
    }

    public int getHp() {
        return hp;
    }
}
