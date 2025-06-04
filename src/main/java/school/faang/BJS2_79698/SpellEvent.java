package school.faang.BJS2_79698;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SpellEvent {
    private int id;
    private EventType eventType;
    private String action;
}
