package school.faang.bjs2_79675;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SpellEvent {

    private int id;
    private String eventType;
    private String action;
}
