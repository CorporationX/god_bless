package faang.school.godbless.Task10;

public class Pikerman extends Creature {

    @Override
    public int getDmg() {
        return this.quantity*5;
    }

    public Pikerman(String name) {
        super(name);
        this.level = 1;
        this.damage = 5;
        this.defense = 1;
        this.haste = 1;
        this.quantity = 5;
    }

}
