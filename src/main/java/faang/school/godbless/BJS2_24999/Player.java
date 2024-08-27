package faang.school.godbless.BJS2_24999;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Player {
    private String name;
    private int level;
    private int experience;
    public void upLevel() {
        level++;
    }
}
