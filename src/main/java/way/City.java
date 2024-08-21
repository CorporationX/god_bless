package way;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class City {
    @NonNull
    private final String name;
    @NonNull
    private final Location location;
    private int distance;
}
