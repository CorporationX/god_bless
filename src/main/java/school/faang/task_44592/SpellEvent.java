package school.faang.task_44592;

import lombok.Getter;
import lombok.Setter;

@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Некорректное значение типа заклинания!");
        }
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Некорректное описание заклинания!");
        }

        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return "ID : " + id
            + ", Тип заклинания : '" + eventType
            + "', Описание заклинания : '"
            + action;
    }
}
