package school.faang.BJS2_87438;

import lombok.NonNull;

public class SpellCaster {
    public void cast(String nameOfSpell, @NonNull SpellAction spellAction) {
        if (nameOfSpell.isBlank()) {
            throw new IllegalArgumentException("Название заклинания не должно быть пустым");
        }
        System.out.println(spellAction.castSpell(nameOfSpell));
    }
}