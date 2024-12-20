package school.faang.bjs246605;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Location {
    private final String name;
    private final Double latitude;
    private final Double longitude;
}
