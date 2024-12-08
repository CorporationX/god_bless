package school.faang.bjs244617.spells;

import school.faang.bjs244617.SpellEvent;

public enum SpellsData {
    CHARMS(1, SpellEvent.SpellType.CHARMS),
    PROTECTION(2, SpellEvent.SpellType.PROTECTION),
    TRANSFIGURATION(3, SpellEvent.SpellType.TRANSFIGURATION);

    private final int id;
    private final SpellEvent.SpellType eventType;

    SpellsData(int id, SpellEvent.SpellType eventType) {
        this.id = id;
        this.eventType = eventType;
    }

    public int getId() {
        return id;
    }

    public SpellEvent.SpellType getEventType() {
        return eventType;
    }
}
