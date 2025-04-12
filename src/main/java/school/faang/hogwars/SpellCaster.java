package school.faang.hogwars;

import lombok.ToString;

@ToString
public class SpellCaster {

    public void cast(String nameSell, SpellAction spellAction) {
        String result = spellAction.castSpell(nameSell);
        System.out.println(result);
    }
}