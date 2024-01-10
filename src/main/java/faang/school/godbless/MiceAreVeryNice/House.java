package faang.school.godbless.MiceAreVeryNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class House {
    private List<Room> rooms;
    private List<Food> foodsInHouse;

    private void collectingFood(Room room) {
        synchronized (room) {
            System.out.println("Собираем еду в комнате " + room.getName());
            foodsInHouse.addAll(room.getFoodsInRoom());
            room.getFoodsInRoom().clear();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        List<Food> foodInKitchen = new ArrayList<>(List.of(
                new Food("Морковка"),
                new Food("Гречка"),
                new Food("Снеки")
        ));
        List<Food> foodInLounge = new ArrayList<>(List.of(
                new Food("Чай"),
                new Food("Яблоко"),
                new Food("Пицца")
        ));
        List<Food> foodInChildren = new ArrayList<>(List.of(
                new Food("Конфета"),
                new Food("Чипсы"),
                new Food("Сок")
        ));
        List<Food> foodInBedroom = new ArrayList<>(List.of(
                new Food("Печенье"),
                new Food("Кофе"),
                new Food("Вода")
        ));

        House house = new House(new ArrayList<>(List.of(
                new Room("Кухня", new ArrayList<>(foodInKitchen)),
                new Room("Гостинная", new ArrayList<>(foodInLounge)),
                new Room("Детская", new ArrayList<>(foodInChildren)),
                new Room("Спальня", new ArrayList<>(foodInBedroom)),
                new Room("Iгровая", new ArrayList<>(foodInChildren)),
                new Room("Коридор", new ArrayList<>(foodInLounge)),
                new Room("Прихожая", new ArrayList<>(foodInBedroom)),
                new Room("Лестница", new ArrayList<>(foodInKitchen))
        )), new ArrayList<>());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (Room room : house.getRooms()) {
            executor.scheduleAtFixedRate(() -> {
                System.out.println("Том и Джерри побежали собирать еду в комнате " + room.getName());
                house.collectingFood(room);
            }, 0, 10, TimeUnit.SECONDS);
        }
        executor.awaitTermination(30, TimeUnit.SECONDS);
        executor.shutdown();

        System.out.println("Еда в доме собрана!");
        System.out.println(house.foodsInHouse);
    }
}