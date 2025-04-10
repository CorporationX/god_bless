package school.faang.collection.hogwarts.spell;

import lombok.Getter;

@Getter
public class SpellEvent {

    private static int spellCounter;

    private final int id;
    private final SpellType spellType;
    private final String actionDescription;

    public SpellEvent(SpellType spellType, String actionDescription) {
        this.id = spellCounter++;
        this.spellType = spellType;
        this.actionDescription = actionDescription;
    }

    @Override
    public String toString() {
        return "%s: %s".formatted(spellType, actionDescription);
    }
}