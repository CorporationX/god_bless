package abstractionabstraction;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (!opponent.isAlive()) {
            System.out.println("Нельзя атаковать мертвого противника.");
        }
        opponent.takeDamage(this.agility);
    }
}
