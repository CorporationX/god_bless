package school.faang.bjs244699;

import lombok.Getter;

@Getter
public final class SpellEvent {

    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть положительным числом.");
        }
        if (eventType == null || eventType.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип события не может быть пустым.");
        }
        if (action == null || action.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип события не может быть пустым.");
        }
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public SpellEvent(int id, String eventType) {
        this(id, eventType, "Неопределенное действие");
    }

    public SpellEvent(int id) {
        this(id, "Неизвестный тип", "Неопределенное действие");
    }

    @Override
    public String toString() {
        return String.format("SpellEvent{id=%d, eventType='%s', action='%s'}", id, eventType, action);
    }
}