package derschrank.sprint03.task01.bjstwo_48423;

public record Mail(
    int id,
    String msg
) {
    @Override
    public String toString() {
        return String.format("[id:%4d] %s", id, msg);
    }
}
