package faang.school.godbless.Witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Monster {
    private String name;
    private Location location;
    private int strength;
}

