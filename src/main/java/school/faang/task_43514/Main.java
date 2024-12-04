package school.faang.task_43514;

import school.faang.task_43514.enums.Amenities;
import school.faang.task_43514.enums.RoomType;
import school.faang.task_43514.model.Room;

import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BookingNotifier notifier = new BookingNotifier();
        BookingSystem bookingSystem = new BookingSystem(notifier);

        Room room1 = new Room(1, RoomType.MEETING_ROOM, Set.of(Amenities.COFFEE_MACHINE, Amenities.WIFI), true);
        Room room2 = new Room(2, RoomType.CONFERENCE_HALL, Set.of(Amenities.WHITEBOARD, Amenities.WIFI), true);
        Room room3 = new Room(3, RoomType.MEETING_ROOM, Set.of(Amenities.PROJECTOR, Amenities.WIFI), true);

        bookingSystem.addRoom(room1);
        bookingSystem.addRoom(room2);
        bookingSystem.addRoom(room3);

        System.out.println(bookingSystem.findAvailableRooms(LocalDateTime.now(), Set.of(Amenities.WIFI)));
    }
}
