package faang.school.godbless;

public class Pikeman extends Creature {
    public Pikeman(int count) {
        this.name = "Pikeman";
        this.level = 5;
        this.damage = 7;
        this.protection = 6;
        this.speed = 4;
        this.quantity = count;
        this.allDamage = this.damage * this.quantity;
        this.allProtection = this.protection * this.quantity;
    }
}