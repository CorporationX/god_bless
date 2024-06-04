package faang.school.godbless.creation;

public class Angel extends Creature{

    public Angel(String name, int level) {
        super(name, level);
        super.attack = 20;
        super.protection = 20;
        super.speed = 15;
    }
}
