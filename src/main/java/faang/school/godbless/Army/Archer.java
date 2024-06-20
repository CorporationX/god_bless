package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public class Archer extends Unit {
    public Archer(int power){
        super(power, UnitClass.ARCHER);
    }
}
