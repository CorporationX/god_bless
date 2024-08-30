package faang.school.godbless.BJS2_25666;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Vehicle {
    private long id;
    private volatile boolean status;
    private volatile Location location;
}
