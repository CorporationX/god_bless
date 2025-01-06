package derschrank.sprint04.task11.bjstwo_50572;

public record Notification(
        int id,
        String message
) {
    @Override
    public String toString() {
        return String.format("[%d] %s", id, message);
    }
}
