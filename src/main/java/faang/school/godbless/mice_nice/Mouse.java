package faang.school.godbless.mice_nice;

import java.util.List;

public class Mouse {
    private static final int FIRST_MET_FOOD_INDEX = 0;
    private static final int FIRST_MET_ROOM_INDEX = 0;

    public synchronized static void collectFood(House houseToSteelFood, List<Food> stolenFoodList) {
        List<Room> roomList = houseToSteelFood.getRoomList();

        for (int i = 0; i < 2; i++) {
            if (!roomList.isEmpty()) {
                Room roomToSteelFood = roomList.remove(FIRST_MET_ROOM_INDEX);

                steelFoodFromRoom(roomToSteelFood, stolenFoodList);
            } else {
                System.out.println("Wasted, there is no room to steel food from.");
                break;
            }
        }
    }

    private static void steelFoodFromRoom(Room roomToSteelFood, List<Food> stolenFoodList) {
        List<Food> foodList = roomToSteelFood.getRoomFoodList();

        for (int i = 0; i < foodList.size(); i++) {
            stolenFoodList.add(foodList.remove(FIRST_MET_FOOD_INDEX));
        }
    }
}
