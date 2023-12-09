package faang.school.godbless;

import lombok.Getter;

@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
    public StreamEvent(int id, String eventType, String data){
        this.id=id;
        this.eventType=eventType;
        this.data=data;
    }
    public String toString(){
        return getEventType()+", "+getData()+", "+getId();
    }
}
