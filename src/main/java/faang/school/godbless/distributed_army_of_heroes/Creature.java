package faang.school.godbless.distributed_army_of_heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Creature {
    private int power;

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
