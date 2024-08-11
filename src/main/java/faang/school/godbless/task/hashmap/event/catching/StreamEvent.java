package faang.school.godbless.task.hashmap.event.catching;

public record StreamEvent(
        int id,
        String eventType,
        Object data
) {
}
