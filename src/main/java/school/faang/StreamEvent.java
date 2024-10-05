package school.faang;

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

}
