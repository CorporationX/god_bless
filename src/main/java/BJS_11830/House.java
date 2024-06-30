package BJS_11830;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {

    ArrayList<Room> roomList;

    House(ArrayList roomList) {
        this.roomList = roomList;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void collectFood() {
        ArrayList<Food> collectedFoodList = new ArrayList<>();
        for (Room room : this.getRoomList()) {
            collectedFoodList.addAll(room.getFoodInRoomList());
            room.getFoodInRoomList().clear();
            System.out.println("еда собрана");
        }
        System.out.println(collectedFoodList.toString());
    }

    public static void main(String[] args) {
        Food bacon = new Food("bacon");
        Food avocado = new Food("avocado");
        Food cheese = new Food("cheese");
        Food banana = new Food("banana");
        Food popcorn = new Food("popcorn");
        Food pizza = new Food("pizza");
        List<Food> foodInKitchen = new ArrayList<>();
        foodInKitchen.add(bacon);
        foodInKitchen.add(avocado);
        foodInKitchen.add(cheese);
        List<Food> foodInBedroom = new ArrayList<>();
        foodInBedroom.add(banana);
        foodInBedroom.add(popcorn);
        foodInBedroom.add(pizza);
        Room kitchen = new Room("kitchen", (ArrayList<Food>) foodInKitchen);
        Room bedroom = new Room("bedroom", (ArrayList<Food>) foodInBedroom);
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(kitchen);
        roomList.add(bedroom);
        House house = new House(roomList);
        ExecutorService threadPool = Executors.newScheduledThreadPool(5);
        for (int i = 1; i < 5; i++) {
            ((ScheduledExecutorService) threadPool).schedule(() -> house.collectFood(), 30 * i, TimeUnit.SECONDS);
        }
        threadPool.shutdown();
    }
}
