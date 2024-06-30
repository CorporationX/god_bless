package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private Integer level;
    @Setter
    private Integer experience;
}
