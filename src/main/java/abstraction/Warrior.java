package abstraction;

public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }
    @Override
    public void attack(Character enemy) throws NullPointerException{
        if (enemy == null) {
            throw new NullPointerException("Enemy character is null!");
        }
        enemy.health -= this.strength;
        if (enemy.health < 0) {
            enemy.health = 0;
        }
    }
}
