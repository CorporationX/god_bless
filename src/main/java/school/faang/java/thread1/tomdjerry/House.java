package school.faang.java.thread1.tomdjerry;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
public class House {
    public static final int FOOD_NUMBER = 2;
    public static final int POOL_SIZE = 5;
    public static int idRoom = 0;
    public static int workingTime = 300;
    public static final int[] ARRAY_ROOMS = {4, 3, 2, 1, 8, 7, 6, 5, 11, 13, 12, 0, 9, 10};
    private Map<Integer, Room> roomMap;
    private List<Food> collectedFoodList = new ArrayList<>();

    public void collectFood() {
        if (House.idRoom < House.ARRAY_ROOMS.length) {
            int[] arr;
            synchronized (this) {
                arr = new int[]{House.ARRAY_ROOMS[House.idRoom++], House.ARRAY_ROOMS[House.idRoom++]};
            }

            System.out.printf("\nЗадания сформированы! %s", Arrays.toString(arr));

            try {
                Thread.sleep(House.workingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("\nОжидание окончено! %s", Arrays.toString(arr));

            List<Food> foodList;
            for (int i = 0; i < 2; i++) {
                getFoodFromRoom(arr[i]);
                foodList = deleteFoodFromRoom(arr[i]);
                addCollectedFoodToListCollectedFood(foodList, arr[i]);
            }
        } else {
            System.out.println("\nБольше заданий нет!");
        }
    }

    public void getFoodFromRoom(int roomNumber) {
        System.out.printf("\n1.%d Collect food %s from room # %d", roomNumber, roomMap.get(roomNumber).getFoodList(), roomNumber);
    }

    public List<Food> deleteFoodFromRoom(int roomNumber) {
        List<Food> tempListFood = roomMap.get(roomNumber).getFoodList();
        roomMap.get(roomNumber).setFoodList(new ArrayList<>());

        System.out.printf("\n2.%d Deleted food from room # %d", roomNumber, roomNumber);

        return tempListFood;
    }

    public void addCollectedFoodToListCollectedFood(List<Food> foodList, int roomNumber) {
        collectedFoodList.addAll(foodList);
        System.out.printf("\n3.%d Add food to collected food list <===== %s", roomNumber, foodList);
    }

    public boolean isAllFoodWasCollected() {
        return 0 == roomMap.entrySet()
                .stream()
                .filter(integerRoomEntry -> !integerRoomEntry.getValue().getFoodList().isEmpty())
                .mapToInt(value -> 1)
                .sum();
    }

    public static void main(String[] args) throws InterruptedException {

        House house = new House();
        house.roomMap = InitData.initRoomMap(House.ARRAY_ROOMS, FOOD_NUMBER);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(House.POOL_SIZE);
        Runnable runnable = house::collectFood;
        scheduledExecutorService.scheduleAtFixedRate(runnable, 0, 30, TimeUnit.MILLISECONDS);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n======= Еда не собрана!");
            Thread.sleep(100);
            exit = house.isAllFoodWasCollected();
        }

        scheduledExecutorService.shutdown();
        System.out.println("\nЕда в доме собрана!");
    }
}