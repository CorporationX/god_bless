package abstraction;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character enemy) throws NullPointerException{
        if (enemy == null) {
            throw new NullPointerException("Enemy Character is null!");
        }
        enemy.health -= this.agility;
        if (enemy.health < 0) {
            enemy.health = 0;
        }
    }
}
