package faang.school.godbless.lambdas.lovehogvarts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpellCaster {
    private String nameCast;

    public void cast(String stringCast, SpellAction spellAction) {
        System.out.println(spellAction.castSpell(stringCast));
    }
}
