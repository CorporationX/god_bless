package derschrank.sprint03.task04.bjstwo_48413;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House implements HouseInterface {
    private static final String SPLITTER = "------------------------------------\n";
    private static final int MAX_FOOD_PER_ROOM = 5;
    private static final int DEFAULT_COUNT_OF_ROOMS = 10;
    private static final int DEFAULT_COUNT_OF_STAFF = 5;

    private KitchenInterface kitchen;
    private List<RoomInterface> rooms;
    private List<Staff> staff;
    private int countOfStaffs;

    public House() {
        this(DEFAULT_COUNT_OF_ROOMS, DEFAULT_COUNT_OF_STAFF);
    }

    public House(int countOfRooms, int countOfStaffs) {
        this.countOfStaffs = countOfStaffs;
        makeRooms(countOfRooms);
        deliverFoodToRooms();

        kitchen = new Kitchen();
    }


    @Override
    public void collectFood() {
        System.out.println(SPLITTER + "Clearing:");

        List<Thread> staffs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread staff = new Staff(this);
            staffs.add(staff);
            staff.start();
        }

        try {
            for (Thread staff : staffs) {
                staff.join();
            }
        } catch (InterruptedException e) {
            System.out.println("HOTEL. CLEARING WAS INTERRUPTED!!!");
        }
    }


    private void makeRooms(int countOfRooms) {
        rooms = new ArrayList<>();

        String number;
        final int roomsByLevel = 10;
        for (int i = 0; i < countOfRooms; i++) {
            number = String.format("%d0%d", 2 + i / roomsByLevel, i % roomsByLevel);
            rooms.add(new Room(number));
        }
    }

    private void deliverFoodToRooms() {
        Random rnd = new Random();

        int countOfFoodsForThisRoom;
        for (RoomInterface room : rooms) {
            countOfFoodsForThisRoom = rnd.nextInt(MAX_FOOD_PER_ROOM);
            for (int i = 1; i <= countOfFoodsForThisRoom; i++) {
                room.receiveFood(new Food(String.format("#%s.%d", room.getNumber(), i)));
            }
        }
    }


    @Override
    public String toString() {
        int foodInRooms;
        int foodInKitchen;
        StringBuilder result = new StringBuilder(
                String.format("HOTEL/HOUSE HAS ROOMS: %d [FOOD IN ROOMS: %d, IN KITCHEN: %d, TOTAL: %d]\n",
                        rooms.size(),
                        foodInRooms = getCountFoodInAllRooms(),
                        foodInKitchen = kitchen.getCountOfFood(),
                        foodInRooms + foodInKitchen
                )
        );


        result.append(SPLITTER).append("FOOD IN ROOMS:\n");
        for (RoomInterface room : rooms) {
            result.append(room).append("\n");
        }

        result.append(SPLITTER).append("FOOD IN KITCHEN:\n")
                .append(kitchen);

        return result.toString();
    }

    @Override
    public KitchenInterface getKitchen() {
        return kitchen;
    }

    @Override
    public List<RoomInterface> getRooms() {
        return new ArrayList<>(rooms);
    }

    private int getCountFoodInAllRooms() {
        int result = 0;
        for (RoomInterface room : rooms) {
            result += room.getCountOfFood();
        }
        return result;
    }

}
