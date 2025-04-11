package school.faang.bjs2_68757;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SpellEventIdCounter {
    private long idCounter = 0;

    public long getNextSpellEventId() {
        return ++idCounter;
    }
}
