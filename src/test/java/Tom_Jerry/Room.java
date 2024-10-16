package Tom_Jerry;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<Food> room;

    public Room() {
        this.room = new ArrayList<>();
    }

    public List<Food> getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Room{" +
                "room=" + room +
                '}';
    }

    public void initialize(Food food) {
        room.add(food);
    }

    public void cleanRoom() {
        room.clear();
    }

    public boolean hasFood() {
        if (!room.isEmpty()) {
            return true;
        }
        return false;
    }
//        List<String> foodList = new ArrayList<>();
//        for (Food food : room) {
//            foodList.add(food.getFood());
//        }
//        return foodList;

}
