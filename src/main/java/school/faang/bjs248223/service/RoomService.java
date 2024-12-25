package school.faang.bjs248223.service;

import school.faang.bjs248223.model.Room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class RoomService {
    private final List<Room> availableRooms;

    public RoomService(List<Room> rooms) {
        if (rooms == null) {
            throw new IllegalArgumentException("Rooms can't be null");
        }
        availableRooms = rooms.stream()
                .filter(room -> !room.foods().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public synchronized Room[] get2RandomRooms() {
        System.out.println("Log: get2RandomRoom is started");
        Room[] randomRooms = new Room[2];
        Iterator<Room> iterator = availableRooms.iterator();
        for (int i = 0; i < 2 && iterator.hasNext(); i++) {
            randomRooms[i] = iterator.next();
            iterator.remove();
        }
        return randomRooms;
    }
}
