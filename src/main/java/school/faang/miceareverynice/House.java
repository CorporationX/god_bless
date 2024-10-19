package school.faang.miceareverynice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Not enough rooms to collect food.");
            return;
        }

        // Randomly select two different rooms
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1 == room2);


    }
}
