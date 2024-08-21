package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Monster {
    private String name;
    private String city;
    private long timeToKill;
}
