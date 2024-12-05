package school.faang.capturingevents;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SpellEvent {

    private Integer id;
    @Getter
    private String eventType;
    private String action;

}
