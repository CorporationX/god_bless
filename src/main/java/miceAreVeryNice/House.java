package miceAreVeryNice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class House {

    private static final int MAX_ROOM_SELECTED = 2;
    private static final List<Room> SELECTED_ROOM = new ArrayList<>();
    private final List<Food> collectedFood = new ArrayList<>();
    private final List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        if (isAllFoodCollected()) {
            return;
        }
        for (int i = 0; i < MAX_ROOM_SELECTED; i++) {
            SELECTED_ROOM.add(rooms.get(new Random().nextInt(rooms.size())));
        }
        for (Room selectedRoom : SELECTED_ROOM) {
            System.out.println("Поток " + Thread.currentThread().getName() + " использует метод collectFood");
            if (!selectedRoom.getFoods().isEmpty()) {
                System.out.println("Собираемая еда в комнате " + selectedRoom.getName() + ": " + selectedRoom.getFoods());
                collectedFood.addAll(selectedRoom.getFoods());
                selectedRoom.setFoods(List.of());
                System.out.println("Еда в комнате " + selectedRoom.getName() + " собрана.");
                System.out.println();
            }
        }
    }

    public boolean isAllFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }
}
