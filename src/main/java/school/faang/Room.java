package school.faang;

import lombok.Getter;

import java.util.Set;

@Getter
public class Room {
    private final int roomNumber;
    private final String type;
    private final Set<String> amenities;

    public Room(String type, Set<String> amenities, int roomNumber) {
        validateType(type);
        validateAmenities(amenities);
        this.type = type;
        this.amenities = amenities;
        this.roomNumber = roomNumber;
    }

    private void validateType(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("The type can't be null or blank");
        }
    }

    private void validateAmenities(Set<String> amenities) {
        if (amenities == null) {
            throw new IllegalArgumentException("The amenitiesSet can't be null");
        }
        for(String amenity : amenities) {
            if (amenity == null || amenity.isBlank()) {
                throw new IllegalArgumentException("The amenity can't be null or blank");
            }
        }
    }
}
