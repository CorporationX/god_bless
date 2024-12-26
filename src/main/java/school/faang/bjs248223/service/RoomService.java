package school.faang.bjs248223.service;

import school.faang.bjs248223.model.Room;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;


public class RoomService {
    private final Queue<Room> availableRooms;

    public RoomService(List<Room> rooms) {
        availableRooms = rooms.stream()
                .filter(room -> !room.foods().isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public synchronized Room[] get2Rooms() {
        System.out.println("Log: " + Thread.currentThread().getStackTrace()[1].getMethodName() + " is started");
        return new Room[]{availableRooms.poll(), availableRooms.poll()};
    }
}
