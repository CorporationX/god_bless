package faang.school.godbless.task32;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Unit {
    private int power;
    public boolean isMage(){
        return false;
    }
    public boolean isSwordsman(){
        return false;
    }
    public boolean isArcher(){
        return false;
    }



}
