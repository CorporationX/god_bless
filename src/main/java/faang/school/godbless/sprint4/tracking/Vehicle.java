package faang.school.godbless.sprint4.tracking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private int id;
    private volatile boolean status;
    private volatile Location location;

    public boolean getStatus() {
        return this.status;
    }
}
