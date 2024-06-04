package faang.school.godbless.creation;

public class Pikeman extends Creature{

    public Pikeman(String name, int level) {
        super(name, level);
        super.attack = 10;
        super.protection = 7;
        super.speed = 6;
    }
}
