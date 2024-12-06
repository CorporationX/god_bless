package school.faang.bjs244514;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class SpellEvent {
    private int id;
    private String name;
    private String action;
}
