package faang.school.godbless;

public class Griffin extends Creature{
    public Griffin(String name, int level, int ataka, int defence, int velocity, int quantity) {
        super(name, level, ataka, defence, velocity, quantity);
    }
    public Griffin() {
        super("Griffin", 2, 7, 6, 5, 1);
    }
}
