package school.faang.task_48283;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectFoodInHouse = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoomToHouse(Room room){
        rooms.add(room);
    }

    public void collectFood() {
        collectFoodFromRooms();
    }

    private void collectFoodFromRooms() {
        Random random = new Random();
        removeFoodFromRoom(rooms.get(random.nextInt(rooms.size())));
        removeFoodFromRoom(rooms.get(random.nextInt(rooms.size())));
    }

    private void removeFoodFromRoom(Room room) {
        List<Food> foods = room.getFoods();
        collectFoodInHouse.addAll(foods);
    }

}
//Собрать еду из двух случайно выбранных комнат.
//
//Удалить собранную еду из списков еды этих комнат.
//
//Добавить собранную еду в общий список собранной еды.