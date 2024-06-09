package faang.school.godbless.heroes.of.might.and.magic.creatures;

public class Pikeman extends Creature {
    public Pikeman() {
        this.name = "Копейщик";
        this.level = 1;
        this.attack = 10;
        this.protection = 3;
        this.speed = 3;
        this.health = 15 + (level * 2);
    }
}
