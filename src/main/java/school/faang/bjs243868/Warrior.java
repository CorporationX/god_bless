package school.faang.bjs243868;

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 10D, 5D, 3D);
    }

    @Override
    public void attack(Character target) {
        if (!target.isAlive()) {
            System.out.println("Attacker is dead");
            return;
        }
        target.receiveDamage(this.getPower());
    }

}
