package school.faang.magieDigga;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

}