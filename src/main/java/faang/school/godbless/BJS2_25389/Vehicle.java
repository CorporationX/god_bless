package faang.school.godbless.BJS2_25389;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vehicle {
    private final long id;
    private String status;
    private Location location;
}
