package faang.school.godbless;

public class Pikeman extends Creature{

    public Pikeman(String name, int level, int ataka, int defence, int velocity, int quantity) {
        super(name, level, ataka, defence, velocity, quantity);
    }
    public Pikeman() {
        super("Pikeman", 1, 5, 5, 3, 1);
    }
}
