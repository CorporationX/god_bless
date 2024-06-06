package faang.school.godbless;


public class Griffin extends Creature{
    public Griffin(String name, int level, int attack, int protection, int speed, int peekNumber) {
        super();
        this.name = "Griffin";
        this.level = 10;
        this.attack = 20;
        this.protection = 12;
        this.peekNumber = 100;
    }

    @Override
    int getDamage() {
        return this.getAttack();
    }
}
