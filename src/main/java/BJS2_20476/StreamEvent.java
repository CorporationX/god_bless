package BJS2_20476;

import lombok.Data;

import java.util.Random;

@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = new Random().nextInt(4);
        this.eventType = eventType;
        this.data = data;
    }
}
