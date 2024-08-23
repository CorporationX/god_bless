package faang.school.godbless.BJS223925;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Monster {
    private String name;
    private int[] location;

    public Monster(String name, int... location) {
        this.name = name;
        this.location = location;
    }
}
