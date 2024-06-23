package faang.school.godbless.mice_nice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Informant {
    public static House findHouseToSteelFood() {
        String[] rooms = getRoomList();
        String[] foods = getFoodList();

        Random randomizer = new Random();

        Queue<Room> roomList = new LinkedList<>();

        for (String roomName : rooms) {
            Queue<Food> foodList = new LinkedList<>();

            for (int foodIndex = 0; foodIndex < 3; foodIndex++) {
                Food foodToRoom = new Food(foods[randomizer.nextInt(0, foods.length)]);
                foodList.add(foodToRoom);
            }

            roomList.add(new Room(roomName, foodList));
        }

        return new House(roomList);
    }

    private static String[] getRoomList() {
        return new String[]{"Kitchen", "Living room", "Bedroom", "Dinning room", "Hall", "Bathroom",
                "Garage", "Terrace", "AnotherBedroom", "AnotherKitchen"};
    }

    private static String[] getFoodList() {
        return new String[]{"Cake", "Cheese", "Jam", "Flakes", "Butter", "Bread", "Eggs", "Milk"};
    }
}
