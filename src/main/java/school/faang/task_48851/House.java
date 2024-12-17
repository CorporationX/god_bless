package school.faang.task_48851;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class House {
    private List<Room> rooms;
    private String houseName;
    private int roomsNumber;

    public House(String houseName, int roomsNumber) {
        this.houseName = houseName;
        this.roomsNumber = roomsNumber;

        createRooms(roomsNumber);

    }

    private void createRooms(int countRoom) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < countRoom; i++) {
            rooms.add(new Room());
        }
        this.rooms = rooms;
    }


    /*
    В классе House реализуйте метод collectFood(), который будет:

    Собирать еду из двух случайно выбранных комнат.

    Удалить собранную еду из списков еды этих комнат.

    Добавить собранную еду в общий список собранной еды.
     */

    public void collectFood(List<Food> foodList) {
        List<Room> newRooms = new ArrayList<>();


    }
}
