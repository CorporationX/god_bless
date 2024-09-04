package faang.school.godbless.multithreading.miceverynice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class House {

    private List<Room> rooms;

    public void deleteFood(Food food) {
        System.out.printf("> searching: %s%n", food.getName());

        for (Room room : rooms) {
            if (room.contains(food)) {
                System.out.printf("> %s is in room: %s%n", food.getName(), room.getName());

                room.remove(food);

                return;
            } else {
                System.out.printf("> no %s in room: %s%n", food.getName(), room.getName());
            }
        }

        System.out.println("> no food in rooms: " + food.getName());
    }

}