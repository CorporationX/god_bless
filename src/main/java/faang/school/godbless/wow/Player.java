package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Player {
    @Getter
    private String name;
    private Integer level;
    @Getter
    private Integer experience;
}
