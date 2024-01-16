package faang.school.godbless.multi_con.task5traking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    private final int id;
    private volatile String status;
    private volatile Location location;
}
