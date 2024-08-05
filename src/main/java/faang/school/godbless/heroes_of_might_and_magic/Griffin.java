package faang.school.godbless.heroes_of_might_and_magic;

public class Griffin extends Creature {
    public Griffin() {
        super();
        this.name = "Griffin";
        this.level = 1;
        this.protection = 2;
        this.speed = 1;
        this.quantity = 2;
    }

    @Override
    public int getDamage() {
        return 1;
    }
}
