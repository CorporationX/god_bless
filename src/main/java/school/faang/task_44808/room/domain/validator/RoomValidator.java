package school.faang.task_44808.room.domain.validator;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_44808.room.domain.enumeration.RoomAmenity;
import school.faang.task_44808.room.domain.enumeration.RoomType;

import java.util.Objects;
import java.util.Set;

@Slf4j
public class RoomValidator {
    private static final String ROOM_TYPE_NULL_ERROR = "Room type is null";
    private static final String ROOM_AMENITIES_NULL_ERROR = "Room amenities are null";
    private static final String ROOM_AMENITIES_EMPTY_ERROR = "Room amenities are empty";
    private static final String ROOM_AMENITIES_CONTAIN_NULL_ERROR = "Room amenities contain null";

    public void validateRoom(RoomType type, Set<RoomAmenity> amenities) {
        validateRoomTypeNotNull(type);
        validateRoomAmenitiesNotEmpty(amenities);
    }

    private void logAndThrow(String errorMessage) {
        log.error(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

    private <T> void validateNotNull(T object, String errorMessage) {
        if (object == null) {
            logAndThrow(errorMessage);
        }
    }

    private void validateRoomAmenitiesNotEmpty(Set<RoomAmenity> amenities) {
        validateNotNull(amenities, ROOM_AMENITIES_NULL_ERROR);

        if (amenities.isEmpty()) {
            logAndThrow(ROOM_AMENITIES_EMPTY_ERROR);
        }

        if (amenities.stream().anyMatch(Objects::isNull)) {
            logAndThrow(ROOM_AMENITIES_CONTAIN_NULL_ERROR);
        }
    }

    private void validateRoomTypeNotNull(RoomType type) {
        validateNotNull(type, ROOM_TYPE_NULL_ERROR);
    }
}