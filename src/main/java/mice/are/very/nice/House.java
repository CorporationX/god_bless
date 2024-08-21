package mice.are.very.nice;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class House {
    private final static int MAX_ROOMS_PER_TIME = 2;
    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        for (int i = 0; i < MAX_ROOMS_PER_TIME; i++) {
            Optional<Room> room = this.getRoomWithFood();
            if (room.isEmpty()) {
                throw new RuntimeException("Не осталось комнат с едой");
            }

            collectFood(room.get());
        }
    }

    private synchronized void collectFood(Room room) {
        System.out.printf("Начали сбор еды из комнаты: %s\n", room.getName());
        this.collectedFood.addAll(room.getFoods());
        room.getFoods().clear();
        System.out.printf("Собрали всю еду из комнаты: %s\n", room.getName());
    }

    private synchronized Optional<Room> getRoomWithFood() {
        return rooms.stream()
            .filter((room) -> !room.getFoods().isEmpty())
            .findFirst();
    }
}
