package faang.school.godbless.java_hashmap.catch_event;


import lombok.Data;

@Data

public class StreamEvent {
    private static int nextId = 0;

    private int id;
    private EventType eventType;
    private String data;


    public StreamEvent( EventType eventType, String data) {
        this.id = getNextId();
        this.eventType = eventType;
        this.data = data;
    }

    static int getNextId() {
        return nextId++;
    }
}


enum EventType {
    USER_LOGIN,
    USER_LOGOUT,
    USER_REGIS,
    USER_PAYMENT,
}