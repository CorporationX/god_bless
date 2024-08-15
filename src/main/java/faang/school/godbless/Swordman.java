package faang.school.godbless;

public class Swordman extends Creature{
    public Swordman(String name, int level, int ataka, int defence, int velocity, int quantity) {
        super(name, level, ataka, defence, velocity, quantity);
    }

    public Swordman() {
        super("Swordman", 3, 10, 8, 4, 1);
    }
}
