package faang.school.godbless.module1.sprint1.task8;

import lombok.Getter;

@Getter
public class Pikeman extends Creature{

    public Pikeman() {
        super();
        this.name = "Pikeman";
        this.lvl = 10;
        this.attack = 15;
        this.defense = 5;
        this.speed = 10;
        this.heals = 100;
    }


}
