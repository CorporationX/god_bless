package school.faang.lovim_sobitii;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

}
