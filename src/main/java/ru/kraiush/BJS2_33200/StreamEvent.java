package ru.kraiush.BJS2_33200;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;
}
