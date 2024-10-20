package MultithreadingTomJerry;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class House {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize() {
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

        List<Food> foods1 = new ArrayList<>();
        List<Food> foods2 = new ArrayList<>();
        List<Food> foods3 = new ArrayList<>();


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

        Room room1 = new Room(foods1);
        Room room2 = new Room(foods2);
        Room room3 = new Room(foods3);

        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
    }

    public void collectFood() {
        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        while (room1 == room2) {
            room2 = rooms.get(random.nextInt(rooms.size()));
        }

        List<Food> collectedFoods = new ArrayList<>();

        for (int i = 0; i < room1.getFoods().size(); i++) {
            if (room1.hasFood()) {
                for (int j = 0; j < room1.getFoods().size(); j++) {
                    collectedFoods.add(room1.getFoods().get(j));
                    room1.getFoods().remove(j);
                    System.out.println("Foods collected by " + Thread.currentThread().getName());
                }

            }
        }

        for (int i = 0; i < room2.getFoods().size(); i++) {
            if (room2.hasFood()) {
                for (int j = 0; i < room2.getFoods().size(); j++) {
                    collectedFoods.add(room2.getFoods().get(j));
                    room2.getFoods().remove(j);
                    System.out.println("Foods collected by " + Thread.currentThread().getName());
                }
            }
        }
    }

    public boolean allFoodsCollected() {
        List<Room> r = rooms.stream()
                .filter(room -> !room.hasFood())
                .toList();
        return r.size() >= 2;
    }
}