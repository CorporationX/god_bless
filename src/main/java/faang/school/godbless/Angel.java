package faang.school.godbless;

public class Angel extends Creature{
    public Angel(int count) {
        this.name = "Angel";
        this.level = 20;
        this.damage = 10;
        this.protection = 10;
        this.speed = 10;
        this.quantity = count;
        this.allDamage = this.damage * this.quantity;
        this.allProtection = this.protection * this.quantity;
    }
}
