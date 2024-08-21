package pave.way.with.your.finger;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private final String name;
    private final Location location;
    private final long distanceToWither;
}
