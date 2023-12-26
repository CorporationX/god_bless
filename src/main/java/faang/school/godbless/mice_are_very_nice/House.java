package faang.school.godbless.mice_are_very_nice;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(List<Room> rooms) {
        this.rooms = rooms;
        this.collectedFood = new ArrayList<>();
    }

    public void collectFood() {
        for (Room room : rooms) {
            List<Food> foodList = room.getFoods();
            collectedFood.addAll(foodList);
            foodList.clear();

        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        House house = getHouse();
        System.out.println(house.collectedFood);//проверка
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int time = i * 30; // не одно число,а с умножением,что бы  потоки по очереди выполнялись, а не все сразу
            executorService.schedule(() -> {
                house.collectFood();
                System.out.println("работнули");
            }, time, TimeUnit.SECONDS);
            // time, TimeUnit.SECONDS - сигнатура метода schedule()
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        //без этой штуковины ТОЖЕ выполняется как попало,нужно для корректного выполнения всех задач, с учетом их интервала.
        System.out.println("Вся еда собрана");
        System.out.println(house.collectedFood);
    }

    private static House getHouse() {
        List<Food> foodList = List.of(new Food("картохо"), new Food("помедорка"), new Food("шашлык"));
        List<Food> foodList1 = List.of(new Food("морква"), new Food("акрошка"), new Food("паста с грибами"));

        Room room1 = new Room(new ArrayList<>(foodList)); // именно НОВЫЙ, иначе что попало. Что бы передать копию,а не ссылку
        Room room2 = new Room(new ArrayList<>(foodList1));//Что бы любые изменения в списках этих не отразились на других списках и наоборот

        List<Room> roomList = List.of(room1, room2);
        return new House(roomList);
    }

}
