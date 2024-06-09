package faang.school.godbless;

public class Griffin extends Creature{
    public Griffin(int count) {
        this.name = "Griffin";
        this.level = 2;
        this.damage = 3;
        this.protection = 2;
        this.speed = 9;
        this.quantity = count;
        this.allDamage = this.damage * this.quantity;
        this.allProtection = this.protection * this.quantity;
    }
}
