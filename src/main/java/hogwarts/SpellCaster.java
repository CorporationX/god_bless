package hogwarts;

import java.util.function.UnaryOperator;

public class SpellCaster {
    public void cast(String spellName, UnaryOperator<String> operator) {
        System.out.println(operator.apply(spellName));
    }
}
