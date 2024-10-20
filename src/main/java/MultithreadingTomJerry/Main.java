package MultithreadingTomJerry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int CORE_POOL_SIZE = 5;
    public static void main(String[] args) {
        House house = new House();
        initialize(house);

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        exec.scheduleAtFixedRate(() -> {
            house.collectFood();

            if (house.allFoodsCollected()) {
                exec.shutdown();
                System.out.println("All foods collected");
            }
        }, 0, 5, TimeUnit.SECONDS);
    }

    public static void initialize(House house) {
        Food kfc = new Food("KFC");
        Food hamburger = new Food("Hamburger");
        Food hotdog = new Food("Hotdog");
        Food taco = new Food("Taco");
        Food lavash = new Food("Lavash");
        Food cheeseburger = new Food("Cheeseburger");
        Food dorum = new Food("Dorum");
        Food spaghetti = new Food("Spaghetti");
        Food pizza = new Food("Pizza");
        Food friedChicken = new Food("Fried Chicken");
        Food hamburger1 = new Food("Hamburger");
        Food hotdog2 = new Food("Hotdog");
        Food taco1 = new Food("Taco");
        Food lavash1 = new Food("Lavash");
        Food cheeseburger1 = new Food("Cheeseburger");
        Food dorum1 = new Food("Dorum");
        Food spaghetti1 = new Food("Spaghetti");
        Food pizza1 = new Food("Pizza");
        Food friedChicken1 = new Food("Fried Chicken");

        List<Food> foods1 = new ArrayList<>();
        List<Food> foods2 = new ArrayList<>();
        List<Food> foods3 = new ArrayList<>();
        List<Food> foods4 = new ArrayList<>();
        List<Food> foods5 = new ArrayList<>();
        List<Food> foods6 = new ArrayList<>();
        List<Food> foods7 = new ArrayList<>();
        List<Food> foods8 = new ArrayList<>();
        List<Food> foods9 = new ArrayList<>();
        List<Food> foods10 = new ArrayList<>();
        List<Food> foods11 = new ArrayList<>();
        List<Food> foods12 = new ArrayList<>();
        List<Food> foods13 = new ArrayList<>();
        List<Food> foods14 = new ArrayList<>();
        List<Food> foods15 = new ArrayList<>();


        foods1.add(kfc);
        foods1.add(hamburger);
        foods1.add(hotdog);

        foods2.add(taco);
        foods2.add(lavash);
        foods2.add(cheeseburger);

        foods3.add(friedChicken);
        foods3.add(dorum);
        foods3.add(spaghetti);
        foods3.add(pizza);

        foods4.add(kfc);
        foods4.add(hamburger);
        foods4.add(hotdog);

        foods5.add(taco);
        foods5.add(lavash);
        foods5.add(cheeseburger);

        foods6.add(dorum);
        foods6.add(spaghetti);
        foods6.add(pizza);

        foods7.add(kfc);
        foods7.add(hamburger);
        foods7.add(hotdog);

        foods8.add(taco);
        foods8.add(lavash);
        foods8.add(cheeseburger);

        foods9.add(dorum);
        foods9.add(spaghetti);
        foods9.add(pizza);

        foods10.add(kfc);
        foods10.add(hamburger);
        foods10.add(hotdog);

        foods11.add(taco);
        foods11.add(lavash);
        foods11.add(cheeseburger);

        foods12.add(dorum);
        foods12.add(spaghetti);
        foods12.add(pizza);

        foods13.add(kfc);
        foods13.add(hamburger);
        foods13.add(hotdog);

        foods14.add(taco);
        foods14.add(lavash);
        foods14.add(cheeseburger);

        foods15.add(dorum);
        foods15.add(spaghetti);
        foods15.add(pizza);

        Room room1 = new Room(foods1);
        Room room2 = new Room(foods2);
        Room room3 = new Room(foods3);
        Room room4 = new Room(foods4);
        Room room5 = new Room(foods5);
        Room room6 = new Room(foods6);
        Room room7 = new Room(foods7);
        Room room8 = new Room(foods8);
        Room room9 = new Room(foods9);
        Room room10 = new Room(foods10);
        Room room11 = new Room(foods11);
        Room room12 = new Room(foods12);
        Room room13 = new Room(foods13);
        Room room14 = new Room(foods14);
        Room room15 = new Room(foods15);

        house.getRooms().add(room1);
        house.getRooms().add(room2);
        house.getRooms().add(room3);
        house.getRooms().add(room4);
        house.getRooms().add(room5);
        house.getRooms().add(room6);
        house.getRooms().add(room7);
        house.getRooms().add(room8);
        house.getRooms().add(room9);
        house.getRooms().add(room10);
        house.getRooms().add(room11);
        house.getRooms().add(room12);
        house.getRooms().add(room13);
        house.getRooms().add(room14);
        house.getRooms().add(room15);
    }
}
