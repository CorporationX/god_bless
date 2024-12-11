package school.faang.bjs244699;

import lombok.Getter;

@Getter
public final class SpellEvent {

    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
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

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID должен быть положительным числом.");
        }
    }

    public void setEventType(String eventType) {
        if (eventType != null || eventType.trim().isEmpty()) {
            this.eventType = eventType;
        } else {
            throw new IllegalArgumentException("Тип события не может быть пустым.");
        }
    }

    public void setAction(String action) {
        if (action != null || action.trim().isEmpty()) {
            this.action = action;
        } else {
            throw new IllegalArgumentException("Тип события не может быть пустым.");
        }
    }

    @Override
    public String toString() {
        return String.format("SpellEvent{id=%d, eventType='%s', action='%s'}", id, eventType, action);
    }
}
