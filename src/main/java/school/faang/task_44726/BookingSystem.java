package school.faang.task_44726;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static school.faang.task_44726.ConsoleInteraction.bookingNotifier;

public class BookingSystem {
    private List<Room> roomList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public int addNewSingleRoom() {
        Room room = Room.builder()
                .type(RoomType.getRandomRoomType())
                .amenities(Amenities.getSetOfAmenities())
                .build();
        roomList.add(room);
        return room.getRoomId();
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
        Room roomToBook = findRoomBId(roomId);

        if (!isRoomAlreadyBooked(roomId)) {
            Booking booking = Booking.builder()
                    .room(roomToBook)
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
            if (booking.getRoom().getRoomId() == roomId) {
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
            System.out.println("\nBooking list is empty");
        }
    }

    public void findAvailableRooms(String dayOfTheWeek, String timeSlot, Set<String> requiredAmenities) {
        List<Room> availableRoomForBooking = new ArrayList<>();
        availableRoomForBooking.addAll(roomList);
        for (Room room : roomList) {
            int roomId = room.getRoomId();
            for (Booking booking : bookingList) {
                if (booking.getRoom().getRoomId() == roomId) {
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
        availableRoomForBooking.forEach(System.out::println);
    }

    private boolean isAmenitiesAvailable(Room room, Set<String> requiredAmenities) {
        return room.getAmenities().containsAll(requiredAmenities);
    }

    private boolean isDateAvailable(Booking booking, String dayOfTheWeekBookingStarts, String timeSlot) {
        return !booking.getDate().equals(dayOfTheWeekBookingStarts);
    }

    private Room findRoomBId(int roomId) {
        return roomList.stream()
                .filter(item -> item.getRoomId() == roomId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Room with id --> " + roomId + " <-- is not in the system"));
    }
}