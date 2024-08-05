package faang.school.godbless.heroes_of_might_and_magic;

public class Pikeman extends Creature {
    public Pikeman() {
        super();
        this.name = "Pikeman";
        this.level = 1;
        this.protection = 1;
        this.speed = 2;
        this.quantity = 3;
    }

    @Override
    public int getDamage() {
        return 3;
    }
}
