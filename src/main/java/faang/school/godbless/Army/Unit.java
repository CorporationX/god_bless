package faang.school.godbless.Army;

import com.sun.source.tree.BreakTree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;
    private UnitClass unitClass;

}

