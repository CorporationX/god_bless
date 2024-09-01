package faang.school.godbless.BJS2_25405;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    private int id;
    private Status status;
    private Location location;

    public void nextStatus() {
        switch (status) {
            case BUSY -> status = Status.FREE;
            case FREE -> status = Status.BUSY;
        }
    }
}
