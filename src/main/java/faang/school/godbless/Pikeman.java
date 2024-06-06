package faang.school.godbless;


public class Pikeman extends Creature{
    public Pikeman(String name, int level, int attack, int protection, int speed, int peekNumber) {
        super();
        this.name = "Pikeman";
        this.level = 10;
        this.attack = 20;
        this.protection = 12;
        this.peekNumber = 1;
    }

    @Override
    int getDamage() {
        return this.getAttack();
    }
}
