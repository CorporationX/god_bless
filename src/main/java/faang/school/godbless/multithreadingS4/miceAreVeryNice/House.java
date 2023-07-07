package faang.school.godbless.multithreadingS4.miceAreVeryNice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class House {
    private String name;
    private List<Room> rooms;
    private List<Food> collectFood;

    public House(String name) {
        this.name = name;
        rooms = fillRooms();
        collectFood = new ArrayList<>();
    }

    public void collectFood(int startIndex, int countRoomForVisit) {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s starts.%n", threadName);
        for (int j = 0; j < countRoomForVisit && startIndex < rooms.size(); j++, startIndex++) {
            Room room = rooms.get(startIndex);
            System.out.printf("Started collecting food in %s, count food in room - %d.%n",
                    room.getName(),
                    room.getFoods().size());
            collectFood.addAll(room.getFoods());
            room.getFoods().clear();
            System.out.printf("Food in the room %s is collected.%n", room.getName());
        }
        System.out.printf("\t%s is finished.%n%n", threadName);
    }

    private List<Room> fillRooms() {
        int countRooms = 20;
        List<Room> rooms = new ArrayList<>(countRooms);
        Random random = new Random();
        for (int i = 0; i < countRooms; i++) {
            int countFoodInRoom = random.nextInt(10) + 1;
            List<Food> foods = new ArrayList<>(countFoodInRoom);
            for (int j = 0; j < countFoodInRoom; j++) {
                int caloric = random.nextInt(140) + 10;
                foods.add(new Food("Food name: " + j, caloric));
            }
            rooms.add(new Room("Room: " + (i + 1), foods));
        }
        System.out.println("The rooms are filled with food.\n");
        return rooms;
    }

}
