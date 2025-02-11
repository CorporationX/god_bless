package school.faang.sprint.second.hogwarts;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellCaster {
    private static final String REGEX = "[a-zA-Zа-яА-Я]+";

    public void cast(@NonNull String spellName, SpellAction spellAction) {
        if (spellName.isBlank()) {
            throw new IllegalArgumentException("Spell name cannot be blank");
        }
        if (containsSymbolsOrDigits(spellName)) {
            throw new IllegalArgumentException("Spell name cannot contain digits or symbols");
        }
        log.info(spellAction.performSpell(spellName));
    }

    public boolean containsSymbolsOrDigits(@NonNull String spellName) {
        return !spellName.matches(REGEX);
    }
}
