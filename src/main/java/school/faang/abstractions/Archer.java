package school.faang.abstractions;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println("Archer attack");
        enemy.hp -= dexterity;
    }
}
