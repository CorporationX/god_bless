package faang.school.godbless;

public class Angel extends Creature{
    public Angel(String name, int level, int ataka, int defence, int velocity, int quantity) {
        super(name, level, ataka, defence, velocity, quantity);
    }
    public Angel() {
        super("Angel", 5, 15, 12, 8, 1);
    }
}
