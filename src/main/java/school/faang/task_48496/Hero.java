package school.faang.task_48496;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

abstract class Hero {
    protected int power;

    public Hero (int power){
        this.power = power;
    }
}
