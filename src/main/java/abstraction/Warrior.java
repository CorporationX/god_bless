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
        if (enemy.health - this.strength < 0) {
            enemy.health = 0;
        } else {
            enemy.health -= this.strength;
        }
    }
}
