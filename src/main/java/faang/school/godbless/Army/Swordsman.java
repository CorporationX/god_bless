package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


public class Swordsman extends Unit {

    public Swordsman(int power) {
        super(power);
    }

    @Override
    public boolean isSwordsMan(){
        return true;
    }

}
