package faang.school.godbless.heroes.of.might.and.magic.creatures;

public class Swordman extends Creature {
    public Swordman() {
        this.name = "Мечник";
        this.level = 1;
        this.attack = 5;
        this.protection = 5;
        this.speed = 6;
        this.health = 18 + (level * 2);
    }
}
