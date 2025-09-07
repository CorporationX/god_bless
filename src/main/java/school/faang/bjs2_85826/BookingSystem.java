package school.faang.bjs2_85826;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
public class BookingSystem {
    private ArrayList<Room> mapInfoRoom = new ArrayList<>();
    private BookingNotifier notifier = new BookingNotifier();
    private ArrayList<Booking> bookingList = new ArrayList<>();

    public void add(Room room) {
        if (mapInfoRoom.contains(room)) {
            mapInfoRoom.add(room);
            System.out.printf("The room with number %x was added \n", room.getRoomNumber());
        } else {
            System.out.printf("The room with number %x already exists \n", room.getRoomNumber());
        }
    }

    public void remove(int roomNumber) {
        Room room = mapInfoRoom.stream()
                .filter(i -> i.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
        mapInfoRoom.remove(room);
    }

    public void bookRoom(int roomNumber, String date, String timeSlot) {
        Room room = mapInfoRoom.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
        if (room == null) {
            System.out.printf("Sorry!!! Room with number %x is busy((!!! Sorry!!!", roomNumber);
        } else {
            Booking booking = new Booking(new Random().nextInt(Integer.MAX_VALUE), room, date, timeSlot);
            notifier.notifyObservers(booking, "booked");
            System.out.println("Room with number %x was booked");
            mapInfoRoom.add(room);
        }
    }

    public ArrayList<Room> findAvailableRooms(String date, String timeSlot, Set<String> requiredAmenities) {
        ArrayList<Room> resultList = new ArrayList<>();
        ArrayList<Room> listOfEligible = (ArrayList<Room>) mapInfoRoom.stream()
                .filter(r -> requiredAmenities.contains(r.getAmenities()))
                .toList();
        Room room = null;
        for (int i = 0; i< listOfEligible.size(); i++) {
            for (int j = 0; j < bookingList.size(); j++) {
                if (bookingList.get(j).getRoom().equals(listOfEligible.get(i))) {
                    if (!bookingList.get(j).getDate().equals(date) && !bookingList.get(j).getTimeSlot().equals(timeSlot)) {
                        room = listOfEligible.get(i);
                    } else {
                        room = null;
                    }
                }
                if (room != null) {
                    resultList.add(room);
                }
            }
        }
        return resultList;
    }
}
