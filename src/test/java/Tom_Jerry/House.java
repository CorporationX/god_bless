package Tom_Jerry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> house;
    private List<Food> collectedFood;

    public House() {
        this.house = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }


    public List<Room> getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return "House{" +
                "house=" + house +
                ", collectedFood=" + collectedFood +
                '}';
    }

    public void initializeHouse(Room room) {
        house.add(room);
    }

    public List<Food> collectFood() {
        Random random = new Random();
        Room room1 = house.get(random.nextInt(house.size()));
        Room room2 = house.get(random.nextInt(house.size()));
        while (room1 == room2) {
            room2 = house.get(random.nextInt(house.size()));
        }
        if (room1.hasFood() && room2.hasFood()) {
            collectedFood.addAll(room1.getRoom());
            collectedFood.addAll(room2.getRoom());
            room1.cleanRoom();
            room2.cleanRoom();
        }

        return collectedFood ;
    }
    public boolean allFoodCollected(){
        for(Room room:house)
        if (room.getRoom().isEmpty()){
            return true;
        }
        return false;
    }
}

