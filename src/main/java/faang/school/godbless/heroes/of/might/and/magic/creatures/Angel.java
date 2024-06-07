package faang.school.godbless.heroes.of.might.and.magic.creatures;

public class Angel extends Creature {
    public Angel() {
        this.name = "Ангел";
        this.level = 1;
        this.attack = 4;
        this.protection = 10;
        this.speed = 2;
        this.health = 12 + (level * 2);
    }
}
