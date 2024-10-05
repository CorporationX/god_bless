package school.BJS2_32836;

public class Angel extends Creature {

    public Angel(String name, int lvl, int attack, int protect, int speed) {
        super(name, lvl, attack, protect, speed);
    }

    public int getDamage() {
        if (this.health < 30) {
            this.health += 20;
            return attack * 3 + (speed * 2);
        }
        return attack + (int) (Math.random() * speed);
    }
}
