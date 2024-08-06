package com.map.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@Getter

@EqualsAndHashCode
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        if(id < 0 || eventType.isEmpty() || data.isEmpty()){
            throw new IllegalArgumentException("Argument is not valid");
        }else {
            this.id = id;
            this.eventType = eventType;
            this.data = data;
        }
    }
}
