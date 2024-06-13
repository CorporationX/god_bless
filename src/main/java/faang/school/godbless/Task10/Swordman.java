package faang.school.godbless.Task10;

public class Swordman extends Creature{

    @Override
    public int getDmg() {
        return this.quantity*5;
    }

    public Swordman(String name) {
        super(name);
        this.level = 3;
        this.damage = 5;
        this.defense = 2;
        this.haste = 1;
        this.quantity = 4;
    }

}
