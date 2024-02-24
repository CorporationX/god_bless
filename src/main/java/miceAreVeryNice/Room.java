package miceAreVeryNice;

import java.util.List;

public class Room {
    private List<Food> foodList;

    public Room(List<Food> foodList) {
        this.foodList = foodList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public String toString() {
        return foodList.toString();
    }
}
