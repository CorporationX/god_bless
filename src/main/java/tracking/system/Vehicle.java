package tracking.system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Setter
public class Vehicle {
    private final int id;
    private volatile Status status;
    private volatile Location location;
}
