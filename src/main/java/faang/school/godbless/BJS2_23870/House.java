package faang.school.godbless.BJS2_23870;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {
    private List<Room> rooms;

    public void deleteFood(Food food) {
        System.out.println("Nщем: " + food.getName());

        for (Room room : rooms) {
            if (room.contains(food)) {
                System.out.printf("В комнате %s есть %s%n", room.getName(), food.getName());
                room.remove(food);
                return;
            } else {
                System.out.printf("В комнате %s нету %s%n", room.getName(), food.getName());
            }
        }

        System.out.println("Ни в одной комнате не было найдена еда: " + food.getName());
    }
}