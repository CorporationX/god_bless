package school.faang;

import java.util.ArrayList;
import java.util.List;

public class SpellEvent {
    private Integer id;
    private String eventType;
    private String action;

    public SpellEvent(Integer id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
