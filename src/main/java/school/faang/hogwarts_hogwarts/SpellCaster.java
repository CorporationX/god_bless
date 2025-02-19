package school.faang.hogwarts_hogwarts;

import static java.util.Objects.isNull;

public class SpellCaster {

    public void cast(String castName, SpellAction spellAction) {
        if (isNull(castName) || isNull(spellAction)) {
            System.out.println("Принимаемые значения должны быть ненулевыми");
        }
        System.out.println(spellAction.getSpellResult(castName));
    }
}
