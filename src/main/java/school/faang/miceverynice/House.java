package school.faang.miceverynice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


@Data
public class House {
    private List<Room> rooms = createRoomWithData();
    private Boolean isProcessFinished = false;

    public List<Food> collectFood(int roomNumber){
        List<Food> collectedFood = new ArrayList<>();

        if(rooms.size() < roomNumber){
            System.out.println("Your input is bigger than room number");
        }

        for (int i = 0; i < roomNumber; i++){
            Room room = getRandomRoom();
            collectedFood.addAll(Objects.requireNonNull(room).getFoods());
            removeFood(room.getFoods(), room);
        }

        isProcessFinished = rooms.stream().noneMatch(Room::hasFood);

        return collectedFood;
    }

    private void removeFood(List<Food> foods, Room room){
        room.getFoods().removeAll(foods);
    }

    private Room getRandomRoom(){
        Random random = new Random();
        if (rooms.isEmpty()) {
            return null;
        }
        int index = random.nextInt(rooms.size());
        return rooms.get(index);
    }

    private List<Room> createRoomWithData(){
        Food apple = new Food("Яблоко");
        Food banana = new Food("Банан");
        Food orange = new Food("Апельсин");
        Food pear = new Food("Груша");
        Food kiwi = new Food("Киви");

        List<Food> foodListRoom1 = new ArrayList<>();
        foodListRoom1.add(apple);
        foodListRoom1.add(banana);

        List<Food> foodListRoom2 = new ArrayList<>();
        foodListRoom2.add(orange);
        foodListRoom2.add(pear);

        List<Food> foodListRoom3 = new ArrayList<>();
        foodListRoom3.add(kiwi);

        Room room1 = new Room(foodListRoom1);
        Room room2 = new Room(foodListRoom2);
        Room room3 = new Room(foodListRoom3);

        List<Room> roomsList = new ArrayList<>();
        roomsList.add(room1);
        roomsList.add(room2);
        roomsList.add(room3);

        return roomsList;
    }
}
