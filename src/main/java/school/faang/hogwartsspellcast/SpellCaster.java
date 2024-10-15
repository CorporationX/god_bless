package school.faang.hogwartsspellcast;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpellCaster {

    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Spell Result: " + result);
    }
}