package school.faang.MiceAreVeryNice;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
public class House {
    private List<Room> rooms = new ArrayList<>();
    List<Food> collectedFood = new ArrayList<>();
    public void addRoom(Room room){
        this.getRooms().add(0, room);
    }

    public void generateRooms(int roomsAmount, List<String> foodList){
        for (int i = 0; i < roomsAmount; i++) {
            addRoom(new Room());
            getRooms().get(0).addRandomFoods(foodList);
        }
    }

    public boolean allFoodCollected(){
        return rooms.isEmpty();
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));
        if(rooms.remove(room1)){
            collectedFood.addAll(room1.getFoods());
        }
        if(rooms.remove(room2)) {
            collectedFood.addAll(room2.getFoods());
        }
    }
}
