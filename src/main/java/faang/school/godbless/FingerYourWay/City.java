package faang.school.godbless.FingerYourWay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class City {
    private String name;
    private Location location;
    private int distance;
}
