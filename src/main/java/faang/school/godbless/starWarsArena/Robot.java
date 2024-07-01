package faang.school.godbless.starWarsArena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Robot {
    private String name;
    private Integer attackPower;
    private Integer defensePower;
    @Setter
    private Integer helth;
}
