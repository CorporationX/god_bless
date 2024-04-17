package faang.school.godbless.swordandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Character {
    private int power;

    public boolean isMage(){
        return false;
    }

    public boolean isArcher(){
        return false;
    }
    public boolean isSwordsman(){
        return false;
    }
}
