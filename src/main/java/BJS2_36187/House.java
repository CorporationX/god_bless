package BJS2_36187;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> roomsList;
    private final List<Food> collectedFoodList;
    private final int roomsQuantity = 10;
    private final static String[] foodList = new String[]{"Meat", "Soup", "French fries", "Salad", "Icecream"};
    private final Random rand;
    private boolean allFoodIsCollected = false;

    public House() {
        roomsList = new ArrayList<>();
        collectedFoodList = new ArrayList<>();
        rand = new Random();

        for (int i = 0; i < roomsQuantity; i++){
            Room room = new Room();
            int dishesQuantity = 1 + rand.nextInt(7);
            for (int j = 0; j < dishesQuantity; j++){
                room.addFood(new Food(foodList[rand.nextInt(foodList.length)]));
            }
            roomsList.add(room);
        }
    }

    public void printRoomsAndFood(){
        if (!allFoodIsCollected) {
            System.out.println("====================================================");
            for (Room room : roomsList) {
                System.out.println(room);
            }
        }
    }

    public void collectFoodFromRandomRoom(){
        if (allFoodIsCollected){
            return;
        }
        int i = rand.nextInt(roomsQuantity);
        int checkedRoomsQuantity = 0;
        while (checkedRoomsQuantity < roomsQuantity){
            if (roomsList.get(i).isFoodInTheRoom()){
                List<Food> foodFromRoom1 = roomsList.get(i).getAndRemoveFood();
                if (!foodFromRoom1.isEmpty()){
                    collectedFoodList.addAll(foodFromRoom1);
                }
                return;
            }
            if (i != roomsList.size() - 1){
                    i++;
                    checkedRoomsQuantity++;
            } else {
                i = 0;
                checkedRoomsQuantity++;
            }
        }
        allFoodIsCollected = true;
    }

    public void collectFoodFromTwoRandomRooms(){
        for (int i = 0; i < 2; i++){
            if (!allFoodIsCollected) {
                collectFoodFromRandomRoom();
                printRoomsAndFood();
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        House house = new House();
        house.printRoomsAndFood();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable collectFoodFromTwoRooms = () -> house.collectFoodFromTwoRandomRooms();
        scheduledThreadPool.scheduleAtFixedRate(collectFoodFromTwoRooms,1, 2, TimeUnit.SECONDS);

        while (!house.allFoodIsCollected){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scheduledThreadPool.shutdown();
        try {
            scheduledThreadPool.awaitTermination(3,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(house.collectedFoodList);

    }
}
