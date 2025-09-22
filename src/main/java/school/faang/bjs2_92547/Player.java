package school.faang.bjs2_92547;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private final String name;
    private int level;
    private int experience;
}
