package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class City {
    private final String name;
    private final Location location;
}
