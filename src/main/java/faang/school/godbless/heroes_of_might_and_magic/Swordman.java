package faang.school.godbless.heroes_of_might_and_magic;

public class Swordman extends Creature {
    public Swordman() {
        super();
        this.name = "Swordman";
        this.level = 1;
        this.protection = 1;
        this.speed = 3;
        this.quantity = 1;
    }

    @Override
    public int getDamage() {
        return 2;
    }
}
