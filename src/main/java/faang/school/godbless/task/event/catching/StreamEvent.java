package faang.school.godbless.task.event.catching;

public record StreamEvent(
        int id,
        String eventType,
        Object data
) {
}
