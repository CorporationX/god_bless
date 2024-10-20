package school.faang_sprint_3.mice_are_very_nice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public record House(List<Room> rooms) {

    public List<Food> collectFood() {
        var collectedFoodList = new ArrayList<Food>();
        var rooms = getRandomRooms(this.rooms, 2);

        rooms.forEach(room -> {
            if (room.hasFood()) {
                collectedFoodList.addAll(room.removeAllFood());
            } else {
                System.out.println("There is no food in the " + room.name());
            }
        });
        return collectedFoodList;
    }

    public boolean isAllFoodCollected() {
        return rooms.stream().allMatch(Room::hasFood);
    }

    private List<Room> getRandomRooms(List<Room> rooms, int roomAmount) {
        var randomRooms = new ArrayList<Room>();
        var copy = new ArrayList<>(rooms);
        var random = new Random();

        for (int i = 0; i < roomAmount; i++) {
            randomRooms.add(copy.remove(random.nextInt(copy.size())));
        }
        return randomRooms;
    }
}
