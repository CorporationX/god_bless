package school.faang.lordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NonNull
public class Item {
    private String name;
    private int value;
}
