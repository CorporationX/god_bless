package school.faang;

import java.util.Objects;

public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getData(){
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEventType(String eventType){
        this.eventType = eventType;
    }

    public void setData(String Data){
        this.data = data;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, eventType, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StreamEvent streamEvent = (StreamEvent) obj;
        return id == streamEvent.id &&
                Objects.equals(eventType, streamEvent.eventType) &&
                Objects.equals(data, streamEvent.data);

    }
}
