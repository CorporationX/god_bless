package faang.school.godbless.event;

public record StreamEvent(int id, String eventType, String data) {
    public StreamEvent {
        validate(id, eventType, data);
    }

    private void validate(int id, String eventType, String data) {
        if (id < 0 ||
                eventType == null || eventType.trim().isEmpty() ||
                data == null || data.trim().isEmpty()) {
            throw new IllegalArgumentException("Check input data!");
        }
    }
}
