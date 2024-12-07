package school.faang.sprint_1.taskbjs244629;

public enum SpellEventType {
    LEVIOSA("Leviosa", "things start flying"),
    TRANSFIGURATION("Transfiguration", "turn into a toad"),
    DEFENSE("Defence", "block all damage");

    private final String event;
    private final String action;

    SpellEventType(String event, String action) {
        this.event = event;
        this.action = action;
    }
}
