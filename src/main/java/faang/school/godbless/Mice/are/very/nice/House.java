package faang.school.godbless.Mice.are.very.nice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public static void main(String[] args) throws InterruptedException {

        House house = new House();
        house.initialize();

        var executor = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executor.schedule(() -> house.collectFood(), 30, TimeUnit.SECONDS);
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println(house.collectedFood);

        for (Room room : house.getRooms()) {
            System.out.println(room.getFoods());
        }

        System.out.println("Еда собрана");
    }

    public void collectFood() {
        int roomCount = 0;

        for (Room room : this.getRooms()) {

            if (roomCount < 2 & !room.isEmpty()) {

                room.setEmpty(true);
                for (Food food : room.getFoods()) {
                    collectedFood.add(food);
                }
                room.getFoods().clear();

            }
        }
    }

    public void initialize() {
        List<Room> roomList = new ArrayList<>();
        List<Food> foods1 = new ArrayList<>();
        List<Food> foods2 = new ArrayList<>();

        foods1.add(new Food("Сыр"));
        foods1.add(new Food("Курочка"));
        foods1.add(new Food("Холодец"));

        foods2.add(new Food("Молоко"));
        foods2.add(new Food("Отбивная"));
        foods2.add(new Food("Пюрешка"));

        roomList.add(new Room(1, foods1));
        roomList.add(new Room(2, foods2));

        this.setRooms(roomList);
        this.setCollectedFood(new ArrayList<>());
    }
}
