package faang.school.godbless.module1.sprint1.task8;

import lombok.Getter;

@Getter
public class Angel extends Creature{
    public Angel() {
        super();
        this.name = "Angel";
        this.lvl = 10;
        this.attack = 30;
        this.defense = 20;
        this.speed = 20;
        this.heals = 1000;
    }

}
