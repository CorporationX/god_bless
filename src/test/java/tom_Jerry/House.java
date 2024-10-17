package tom_Jerry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;
    private Random random = new Random();

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }


    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public String toString() {
        return "House{" +
                "house=" + rooms +
                ", collectedFood=" + collectedFood +
                '}';
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood() {
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));
        if (room1.hasFood() && room2.hasFood()) {
            collectedFood.addAll(room1.cleanRoom());
            collectedFood.addAll(room2.cleanRoom());
            System.out.println("Collected food: " + collectedFood);
        } else {
            System.out.println("No food left in these rooms");
        }
    }

    public boolean allFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}

