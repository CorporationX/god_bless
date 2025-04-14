package abstractionabstraction;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (!opponent.isAlive()) {
            System.out.println("Нельзя атаковать мертвого противника.");
        }
        opponent.takeDamage(this.strength);
    }
}
