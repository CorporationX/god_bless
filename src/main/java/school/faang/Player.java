package school.faang;

import lombok.Getter;
import lombok.Builder;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Player {
    private String name;
    private int level;
    private int experience;
}
