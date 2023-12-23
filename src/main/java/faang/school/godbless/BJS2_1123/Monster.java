package faang.school.godbless.BJS2_1123;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Monster {
    private String name;
    private Location location;

    public String toString() {
        return getName();
    }

}
