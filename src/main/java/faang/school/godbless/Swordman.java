package faang.school.godbless;

import lombok.ToString;

@ToString
public class Swordman extends Creature{
    public Swordman() {
        super();
        this.name = "Swordman";
        this.level = 10;
        this.attack = 20;
        this.protection = 12;
        this.speed = 3;
        this.peekNumber = 10;
    }
}
