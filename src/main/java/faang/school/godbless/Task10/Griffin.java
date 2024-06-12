package faang.school.godbless.Task10;

public class Griffin extends Creature{

    @Override
    public int getDmg() {
        return this.quantity*4;
    }

    public Griffin(String name) {
        super(name);
        this.level = 1;
        this.damage = 4;
        this.defense = 2;
        this.haste = 4;
        this.quantity = 2;
    }

}
