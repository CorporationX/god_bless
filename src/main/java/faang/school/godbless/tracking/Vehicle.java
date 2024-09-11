package faang.school.godbless.tracking;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Vehicle {
    private final int id;
    private int status;
    private Location location;

    public void setStatus(int status) {
        if (status < 0 || status > 1) {
            throw new IllegalArgumentException("Available statuses are 0 or 1");
        }
        this.status = status;
    }

    public void setLocation(@NonNull Location location) {
        this.location = location;
    }
}
