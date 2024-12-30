package school.faang.sprint_4.task_51208;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Vehicle {
    private final int id;
    private volatile boolean isBusy;
    @NonNull
    private volatile Location location;

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void updateLocation(@NonNull Location newLocation) {
        location = newLocation;
    }
}
