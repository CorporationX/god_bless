package school.faang.task_44726;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static school.faang.task_44726.ConsoleInteraction.bookingNotifier;


public class BookingSystem {

    private static final int NUMBER_OF_ROOM = 10;

    private List<Room> roomList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();

    private void addRoom(Room room) {
        roomList.add(room);
    }

    public void addMultipleRoomsForMyTask() {
        for (int i = 0; i < NUMBER_OF_ROOM; i++) {
            addRoom(Room.builder()
                    .roomId(i)
                    .type(RoomType.getRandomRoomType())
                    .amenities(Amenities.getSetOfAmenities())
                    .build()
            );
        }
    }

    public void addNewSingleRoom(int roomId) {
        roomList.add(Room.builder()
                .roomId(roomId)
                .type(RoomType.getRandomRoomType())
                .amenities(Amenities.getSetOfAmenities())
                .build()
        );
    }

    public void removeRoom(int roomId) {
        for (Room room : roomList) {
            if (room.getRoomId() == roomId) {
                roomList.remove(room);
                break;
            }
        }
    }

    public void bookRoom(int roomId, String bookingDay) {
        UUID uuid = UUID.randomUUID();
        if (!isRoomAlreadyBooked(roomId)) {
            Booking booking = Booking.builder()
                    .bookingId(uuid)
                    .roomId(roomId)
                    .date(bookingDay)
                    .timeSlot("2d")
                    .build();
            bookingList.add(booking);
            bookingNotifier.notifyObservers(booking, " BOOKED");
        } else {
            System.out.println("The room with id " + roomId + " already booked");
        }
    }

    public void cancelBooking(String bookingId) {
        for (Booking booking : bookingList) {
            if (String.valueOf(booking.getBookingId()).equals(bookingId)) {
                bookingList.remove(booking);
                bookingNotifier.notifyObservers(booking, "  CANCELED");
                break;
            } else {
                System.out.println("The booking with id " + bookingId + " is not in the booking list");
            }
        }
    }

    private boolean isRoomAlreadyBooked(int roomId) {
        for (Booking booking : bookingList) {
            if (booking.getRoomId() == roomId) {
                return true;
            }
        }
        return false;
    }

    public void listAllAvailableRoom() {
        for (Room room : roomList) {
            System.out.println(room.toString());
        }
    }

    public void listAllCurrentBooking() {
        if (bookingList.size() > 0) {
            for (Booking booking : bookingList) {
                System.out.println(booking.toString());
            }
        } else {
            System.out.println("");
            System.out.println("Booking list is empty");
        }
    }

    public void findAvailableRooms(String dayOfTheWeek, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRoomForBooking = new ArrayList<>();
        for(Room room : roomList){
            availableRoomForBooking.add(room);
        }
        for (Room room : roomList) {
            int roomId = room.getRoomId();
            for (Booking booking : bookingList) {
                if (booking.getRoomId() == roomId) {
                    boolean isAvailableOnDates = isDateAvailable(booking, dayOfTheWeek, timeSlot);
                    if (!isAvailableOnDates) {
                        availableRoomForBooking.remove(room);
                    }
                }
            }
            if (!isAmenitiesAvailable(room, requiredAmenities)) {
                availableRoomForBooking.remove(room);
            }
        }
        System.out.println("Available room for booking: \n");
        for (Room room : availableRoomForBooking) {
            System.out.println(room);
        }
    }

    private boolean isAmenitiesAvailable(Room room, Set<String> requiredAmenities) {
        if (room.getAmenities().containsAll(requiredAmenities)) {
            return true;
        }
        return false;
    }

    private boolean isDateAvailable(Booking booking, String dayOfTheWeekBookingStarts, String timeSlot) {
        if (booking.getDate().equals(dayOfTheWeekBookingStarts)) {
            return false;
        }
        return true;
    }
}