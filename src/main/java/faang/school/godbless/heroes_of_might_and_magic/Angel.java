package faang.school.godbless.heroes_of_might_and_magic;

public class Angel extends Creature {
    public Angel() {
        super();
        this.name = "Angel";
        this.level = 1;
        this.protection = 1;
        this.speed = 1;
        this.quantity = 3;
    }

    @Override
    public int getDamage() {
        return 5;
    }
}
