package faang.school.godbless.heroes.of.might.and.magic.creatures;

public class Griffin extends Creature {
    public Griffin() {
        this.name = "Грифон";
        this.level = 1;
        this.attack = 10;
        this.protection = 4;
        this.speed = 8;
        this.health = 10 + (level * 2);
    }
}
