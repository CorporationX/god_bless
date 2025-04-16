package school.faang.catch_events;

import lombok.Data;

import java.util.Random;

@Data
public class SpellEvent {
    private static final int RANDOM_SEED = 9999;
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        this.id = createId();
    }

    private int createId() {
        Random rand = new Random();
        return rand.nextInt(RANDOM_SEED);
    }
}
