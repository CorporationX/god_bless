package faang.school.godbless.BJS211012;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Character {
    private int power;
    private String type;

    public boolean isArcher(){
        return false;
    }
    public boolean isMage(){
        return false;
    }
    public boolean isSwordsman(){
        return false;
    }
}
