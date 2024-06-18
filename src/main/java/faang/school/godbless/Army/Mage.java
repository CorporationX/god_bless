package faang.school.godbless.Army;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
public class Mage extends Unit {

    public Mage(int power){
        super(power);
    }

    @Override
    public boolean isMage(){
        return true;
    }
}

