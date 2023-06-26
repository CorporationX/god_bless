package faang.school.godbless.distributedArmy;

import lombok.Data;
import lombok.NonNull;

@Data
public class Warrior {
    @NonNull
    private String name;
    @NonNull
    private int power;
}
