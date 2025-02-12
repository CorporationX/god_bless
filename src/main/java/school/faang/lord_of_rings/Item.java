package school.faang.lord_of_rings;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Item {
    private final @NonNull String name;
    @Setter
    private int value;
}
