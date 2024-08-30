package faang.school.godbless.transportTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Vehicle {
    private final int id;
    @Setter
    private volatile String status;
    @Setter
    private volatile Location location;
}
