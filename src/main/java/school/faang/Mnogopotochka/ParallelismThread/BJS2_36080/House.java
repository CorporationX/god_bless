package school.faang.Mnogopotochka.ParallelismThread.BJS2_36080;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        house.init();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        try {
            service.scheduleAtFixedRate(house::collectFood, 0, 30, TimeUnit.SECONDS);
            Thread.sleep(5 * 60 * 1000);
            System.out.println("Еда в доме собрана!");
        } finally {
            service.shutdown();
        }
    }

    public void init() {
        rooms.add(new Room("Спальня", List.of("Сыр", "Колбаса")));
        rooms.add(new Room("Гостевая", List.of("Орешек", "Сахарок")));
        rooms.add(new Room("Кухня", List.of("Мясо", "Маслины")));
        rooms.add(new Room("Ванная", List.of("Леденец")));
        rooms.add(new Room("Гардероб", List.of("Чипса", "Сыр", "Кабачок")));
        rooms.add(new Room("Чердак", List.of("Огурцы", "Помидоры")));
    }

    public void collectFood() {
        Random random = new Random();

        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2;
        do {
            room2 = rooms.get(random.nextInt(rooms.size()));
        } while (room1 == room2);

        collectedFood.addAll(room1.getFoods());
        room1.getFoods().clear();

        collectedFood.addAll(room2.getFoods());
        room2.getFoods().clear();
    }
}
