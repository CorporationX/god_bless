package school.BJS2_32836;

public class Swordman extends Creature{

    public Swordman(String name, int lvl, int attack, int protect, int speed) {
        super(name, lvl, attack, protect, speed);
    }

    public int getDamage() {
        return attack;
    }
}