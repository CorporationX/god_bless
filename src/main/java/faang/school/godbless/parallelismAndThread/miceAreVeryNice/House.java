package faang.school.godbless.parallelismAndThread.miceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    private static final int NUMBER_OF_ROOMS = 10;
    private static final int NUMBER_OF_FOOD = 5;

    public House() {
        this.rooms = new ArrayList<>();
        this.collectedFood = new ArrayList<>();
    }

    public void initialize() {
        List<Food> foodInRooms = List.of(
                new Food("сыр"),
                new Food("колбаса"),
                new Food("хлеб"),
                new Food("мясо"),
                new Food("молоко"),
                new Food("ветчина"),
                new Food("яйцо")
        );

        List<Room> roomList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            roomList.add(new Room());
        }

        for (int i = 0; i < NUMBER_OF_ROOMS; i++) {
            for (int j = 0; j < NUMBER_OF_FOOD; j++) {
                roomList.get(i).addFood(foodInRooms.get((int) (Math.random() * 7)));
            }
        }

        this.rooms = roomList;
    }

    public void collectFood(int beginIndex) {
        for (int i = beginIndex; i < rooms.size() && i <= beginIndex + 1; i++) {
            collectedFood.addAll(rooms.get(i).getFoodList());
            rooms.get(i).clearFood();
            System.out.println("Поток: " + Thread.currentThread().getName() + ". Завершен сбор еды в " + i + " комнате");
        }
    }
}
