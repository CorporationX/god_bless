package school.faang.lordofrings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Item {

    @NonNull
    private final String name;
    private final int value;
}
