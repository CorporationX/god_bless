package faang.school.godbless.multithreading.fingernavigator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class City {

    private String name;
    private Location location;
    private int distance;

}
