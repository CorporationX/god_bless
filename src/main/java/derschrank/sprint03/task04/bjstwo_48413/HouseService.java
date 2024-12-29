package derschrank.sprint03.task04.bjstwo_48413;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HouseService {
    private static final int MAX_FOOD_PER_ROOM = 5;

    public static List<RoomInterface> getNewRooms(int countOfRooms) {
        List<RoomInterface> rooms = new ArrayList<>();

        String number;
        final int roomsByLevel = 10;
        for (int i = 0; i < countOfRooms; i++) {
            number = String.format("%d0%d", 2 + i / roomsByLevel, i % roomsByLevel);
            rooms.add(new Room(number));
        }
        return rooms;
    }

    public static void deliveryNewFoodToRooms(List<RoomInterface> rooms) {
        Random rnd = new Random();

        int countOfFoodsForThisRoom;
        for (RoomInterface room : rooms) {
            countOfFoodsForThisRoom = rnd.nextInt(MAX_FOOD_PER_ROOM);
            for (int i = 1; i <= countOfFoodsForThisRoom; i++) {
                room.addFood(new Food(String.format("#%s.%d", room.getName(), i)));
            }
        }
    }

    public static boolean hasAnyFoodInRooms(List<RoomInterface> rooms) {
        for (RoomInterface room : rooms) {
            if (room.hasFood()) {
                return true;
            }
        }
        return false;
    }

    public static int getCountOfFoodInAllRooms(List<RoomInterface> rooms) {
        int result = 0;
        for (RoomInterface room : rooms) {
            result += room.getCountOfFood();
        }
        return result;
    }

    public static String getTableOfTheHouseForPrint(List<RoomInterface> rooms,
                                                    List<Food> collectedFood,
                                                    int countOfThreadForRemoveFood) {
        final String splitter = "------------------------------------\n";

        int foodInRooms = getCountOfFoodInAllRooms(rooms);
        int foodInKitchen = collectedFood.size();
        StringBuilder result = new StringBuilder(
                String.format("HOTEL/HOUSE HAS ROOMS: %d [FOOD IN ROOMS: %d, IN COLLECTED FOOD: %d, TOTAL: %d]. "
                                + "THREADS FOR REMOVE FOOD: %d.\n",
                        rooms.size(),
                        foodInRooms,
                        foodInKitchen,
                        foodInRooms + foodInKitchen,
                        countOfThreadForRemoveFood
                )
        );

        result.append(splitter).append("FOOD IN ROOMS:\n");
        for (RoomInterface room : rooms) {
            result.append(room).append("\n");
        }

        result.append(splitter).append("FOOD IN COLLECTED FOOD:\n")
                .append(collectedFood);

        return result.toString();
    }
}
