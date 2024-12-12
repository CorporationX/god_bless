package school.faang.sprint_1.task_44738;

import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Room {
    private static final AtomicInteger idCounter = new AtomicInteger(1);

    private final int id;
    @NonNull
    private final String type;
    @NonNull
    private final Set<String> amenities = new HashSet<>();

    public Room(@NonNull String type, @NonNull Set<String> amenities) {
        this.id = idCounter.getAndIncrement();
        this.type = type;
        this.amenities.addAll(amenities);
    }

    public void addAmenity(@NonNull String amenity) {
        amenities.add(amenity);
    }

    public void removeAmenity(@NonNull String amenity) {
        amenities.remove(amenity);
    }

    public Set<String> getAmenities() {
        return Set.copyOf(amenities);
    }
}
