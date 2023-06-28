package mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;
    private ScheduledExecutorService scheduledExecutorService;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
        scheduledExecutorService = Executors.newScheduledThreadPool(5);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void startFoodCollection() {
        int numberOfThreads = 5;

        List<List<Room>> roomsToCollect = new ArrayList<>();
        for (int startIndex = 0; startIndex < rooms.size(); startIndex += 2) {
            int endIndex = startIndex + 2;
            if (endIndex > rooms.size()) {
                endIndex = rooms.size();
            }
            List<Room> sublist = rooms.subList(startIndex, endIndex);
            roomsToCollect.add(new ArrayList<>(sublist));
        }

        for (List<Room> roomList : roomsToCollect) {
            scheduledExecutorService.submit(() -> collectFood(roomList));
        }

        scheduledExecutorService.shutdown();

        try {
            scheduledExecutorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Food in house collected");
    }

    private void collectFood(List<Room> roomsToCollect) {
        List<Food> collectedFood = new ArrayList<>();

        for (Room room : roomsToCollect) {
            List<Food> foodThisRoom = room.getFoodInTheRoom();
            collectedFood.addAll(foodThisRoom);
        }

        for (Room room : roomsToCollect) {
            room.removeFood();
        }
    }
}
