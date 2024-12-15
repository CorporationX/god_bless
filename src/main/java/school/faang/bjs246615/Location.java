package school.faang.bjs246615;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;
}
