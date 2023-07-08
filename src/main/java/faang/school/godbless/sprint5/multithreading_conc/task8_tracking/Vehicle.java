package faang.school.godbless.sprint5.multithreading_conc.task8_tracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Vehicle {

    private int id;

    @Setter
    private volatile Status status;

    private volatile Location location;

    public void setLocation() {
        location = location.getNewLocation();
    }
}
