package faang.school.godbless.kxnvg.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
@NonNull
public class City {

    private String name;
    private Location location;
    private int distance;
}
