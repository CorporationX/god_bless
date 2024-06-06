package faang.school.godbless;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Angel extends Creature{
    public Angel() {
        super();
        this.name = "Angel";
        this.level = 10;
        this.attack = 20;
        this.protection = 12;
        this.speed = 3;
        this.peekNumber = 100;
    }
}
