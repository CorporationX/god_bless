package bjs257119;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;
}
