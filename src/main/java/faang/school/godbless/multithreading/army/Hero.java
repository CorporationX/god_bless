package faang.school.godbless.multithreading.army;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Hero {
    private Integer power;

    public boolean isArcher(){
        return false;
    }

    public boolean isSwordsman(){
        return false;
    }

    public boolean isMage(){
        return false;
    }
}
