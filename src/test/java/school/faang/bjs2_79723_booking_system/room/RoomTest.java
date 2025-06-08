package school.faang.bjs2_79723_booking_system.room;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void shouldCreateRoomWithValidData() {
        Set<RoomAmenity> amenities = Set.of(RoomAmenity.PROJECTOR, RoomAmenity.WHITEBOARD);
        Room room = new Room(101, RoomType.MEETING, amenities);

        assertEquals(101, room.getRoomNumber());
        assertEquals(RoomType.MEETING, room.getType());
        assertEquals(amenities, room.getAmenities());
    }

    @Test
    void shouldThrowExceptionWhenTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Room(102, null, Set.of(RoomAmenity.TV))
        );
    }

    @Test
    void shouldHandleNullAmenities() {
        Room room = new Room(103, RoomType.CONFERENCE, null);
        assertNull(room.getAmenities());
    }

    @Test
    void shouldDefensivelyCopyAmenities() {
        Set<RoomAmenity> originalAmenities = new HashSet<>();
        originalAmenities.add(RoomAmenity.WC);

        Room room = new Room(104, RoomType.PHONE_BOOTH, originalAmenities);
        originalAmenities.add(RoomAmenity.TV);

        assertEquals(Set.of(RoomAmenity.WC), room.getAmenities());
    }
}
