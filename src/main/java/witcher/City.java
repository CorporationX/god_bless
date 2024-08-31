package witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class City {
    private String name;
    private Location gps;
    private int distance;

}
