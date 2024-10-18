package school.faang.paveTheWay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class City implements Locatable {
    private String name;
    private Location location;
}
