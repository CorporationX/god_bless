package school.faang.bjs243868;

public class Archer extends Character {

    public Archer(String name) {
        super(name, 3D, 10D, 5D);
    }

    @Override
    public void attack(Character target) {
        if (!target.isAlive()) {
            System.out.println("Attacker is dead");
            return;
        }
        target.receiveDamage(this.getAgility());
    }

}
