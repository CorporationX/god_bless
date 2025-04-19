package school.faang.bjs2_69898;

public record SpellEvent(int id, EventType eventType, String action) {
    private static final IdGenerator idGenerator = new IdGenerator();

    public SpellEvent(EventType eventType, String action) {
        this(idGenerator.generateId(), eventType, action);
    }
}