package school.faang.task_44592;

import lombok.Getter;

@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        validEventType(eventType);
        validAction(action);

        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    private static void validAction(String action) {
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Некорректное описание заклинания!");
        }
    }

    private static void validEventType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Некорректное значение типа заклинания!");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID : ")
            .append(id)
            .append(", Тип заклинания : '")
            .append(eventType)
            .append("', Описание заклинания : '")
            .append(action);
        return builder.toString();
    }
}
