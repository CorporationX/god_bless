package way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Monster {
    @NonNull
    private final String name;
    @NonNull
    private final Location location;
}
