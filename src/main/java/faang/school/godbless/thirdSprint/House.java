package faang.school.godbless.thirdSprint;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class House {
    private List<Food> collectedFood;
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        collectedFood = new ArrayList<>();
    }

    public void startFoodCollection() {
        var service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < rooms.size(); i += 2) {
            List<Room> collectionRoom = List.of(rooms.get(i), rooms.get(i + 1));
            service.schedule(() -> collectFood(collectionRoom), 30, TimeUnit.SECONDS);
        }
        service.shutdown();

        try {
            service.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Вся еда в доме собрана.");
    }

    public void collectFood(List<Room> collectionRoom) {
        for (Room room : collectionRoom) {
            System.out.println("Начинаем собирать еду из комнаты " + room.getName());
            collectedFood.addAll(room.getFoodInsideRoom());
            room.removeFood();
        }
    }
}
