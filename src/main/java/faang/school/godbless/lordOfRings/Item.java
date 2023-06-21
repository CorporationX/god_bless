package faang.school.godbless.lordOfRings;

import lombok.Data;
import lombok.NonNull;

@Data
public class Item {
    @NonNull
    private String name;
    @NonNull
    private int value;
}
