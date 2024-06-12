package faang.school.godbless.Task10;

public class Angel extends Creature{

    @Override
    public int getDmg() {
        return this.quantity*6;
    }

    public Angel(String name) {
        super(name);
        this.level = 4;
        this.damage = 6;
        this.defense =21;
        this.haste = 3;
        this.quantity = 1;
    }

}
