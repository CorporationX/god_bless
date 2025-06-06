package school.faang.bjs2_79052;


import lombok.Getter;
import lombok.Setter;

@Getter
public class SpellEvent {
    @Setter
    private static int id = 0;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
    }

    public static int getId() {
        return id;
    }
}
