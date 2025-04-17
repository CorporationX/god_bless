package school.faang.bjs2_70033;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}