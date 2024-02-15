package faang.school.godbless.CatchingEvents;

import java.util.Date;

public class StreamEvent {
    private int id;
    private String eventType;
    private Date date;

    public StreamEvent(int id, String eventType, Date date) {
        this.id = id;
        this.eventType = eventType;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", date=" + date +
                '}';
    }
}
