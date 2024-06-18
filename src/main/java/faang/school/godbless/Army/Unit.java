package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    public boolean isMage(){
        return false;
    }

    public boolean isSwordsMan(){
        return false;
    }

    public boolean isArcher(){
        return false;
    }
}
