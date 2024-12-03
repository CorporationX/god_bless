package school.faang.abstractions;

public class Archer extends Character {
    private int strength = 3;
    private int dexterity = 10;
    private int intelligence = 5;

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("Archer attack");
        enemy.hp -= dexterity;
    }

    public int getHp() {
        return hp;
    }
}
