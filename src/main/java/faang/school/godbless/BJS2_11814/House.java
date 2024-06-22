package faang.school.godbless.BJS2_11814;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
public class House {
    private List<Room> rooms;
    private List<Food> foods;

    public void collectFood(Room room) {
        if (this.foods == null) {
            foods = new ArrayList<>();
        }
        this.foods.addAll(room.getFoods());
    }

    public static void main(String[] args) {
        House house = new House();

        Room dinningRoom = new Room("Dining room");
        Room kitchenRoom = new Room("Kitchen room");
        Room bedRoom = new Room("Bed room");
        Room livingRoom = new Room("living room");
        Room attic = new Room("Attic");

        Food pasta = new Food("Pasta");
        Food frenchFry = new Food("French Fry");
        Food pizza = new Food("pizza");
        Food pie = new Food("Pie");
        Food cake = new Food("Cake");
        Food beefSteak = new Food("beefSteak");
        Food fish = new Food("Fish");

        dinningRoom.addFoodToRoom(pasta, fish);
        kitchenRoom.addFoodToRoom(pasta, pie, beefSteak);
        bedRoom.addFoodToRoom(frenchFry, fish, cake);
        livingRoom.addFoodToRoom(cake, fish, pasta, pizza);
        attic.addFoodToRoom(pasta, fish, beefSteak, frenchFry);

        house.addRooms(dinningRoom, kitchenRoom, bedRoom, livingRoom, attic);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        List<List<Room>> pairs = house.partitionListBy(2, house.getRooms());
        for (List<Room> subList : pairs) {
            service.schedule(() ->
            {
                for (Room room : subList) {
                    System.out.println("Gathering food from " + room.getName());
                    house.collectFood(room);
                }
                System.out.println("Thread is working on task is " + Thread.currentThread().getName());
                System.out.println(house.foods + " food amount is " + house.foods.size());
            }, new Random().nextInt(5), TimeUnit.SECONDS);

        }
        service.shutdown();

        try {
            service.awaitTermination(20, TimeUnit.SECONDS);
            System.out.println(house.partitionListBy(2, house.getRooms()));
            System.out.println(house.foods);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    private List<List<Room>> partitionListBy(int num, List<Room> list) {
        List<List<Room>> pairs = new ArrayList<>();
        List<Room> pair = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % num == 0) {
                pair = new ArrayList<>();
            }
            pair.add(list.get(i));
            if (pair.size() == num) {
                pairs.add(pair);
            }
            if (i == list.size() - 1 && pair.size() != num) {
                pairs.add(pair);
            }
        }
        return pairs;
    }

    public void addRooms(Room... room) {
        if (rooms == null) {
            rooms = new ArrayList<>();
        }
        rooms.addAll(Arrays.asList(room));
    }
}
