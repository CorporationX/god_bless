package CatchEvents;

import lombok.Getter;

@Getter
public class StreamEvent {
    private int id;
    private String type;
    private String data;

    public StreamEvent(int id, String type, String data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
