package faang.school.godbless.Wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private String name;
    private int level;
    private int experience;
}
