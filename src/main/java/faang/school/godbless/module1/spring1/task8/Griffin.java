package faang.school.godbless.module1.spring1.task8;

import lombok.Getter;

@Getter
public class Griffin extends Creature {


    public Griffin() {
        super();
        this.name = "Griffin";
        this.lvl = 10;
        this.attack = 10;
        this.defense = 5;
        this.speed = 20;
        this.heals = 100;
    }

}
