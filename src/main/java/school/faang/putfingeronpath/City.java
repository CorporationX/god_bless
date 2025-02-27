package school.faang.putfingeronpath;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class City {
    @NonNull
    private final String name;
    @NonNull
    private final Location location;
}
