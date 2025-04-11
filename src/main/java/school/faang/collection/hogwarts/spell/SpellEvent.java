package school.faang.collection.hogwarts.spell;

import lombok.Getter;
import school.faang.collection.hogwarts.IdProvider;

@Getter
public class SpellEvent {

    private final int id;
    private final SpellType spellType;
    private final String actionDescription;

    public SpellEvent(SpellType spellType, String actionDescription) {
        this.id = IdProvider.getId();
        this.spellType = spellType;
        this.actionDescription = actionDescription;
    }

    @Override
    public String toString() {
        return "%s: %s".formatted(spellType, actionDescription);
    }
}