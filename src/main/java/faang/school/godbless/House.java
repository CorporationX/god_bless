package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House(ArrayList<Room> rooms, ArrayList<Food> collectedFood) {
        this.rooms = rooms;
        this.collectedFood = collectedFood;
    }
    //Я понимаю, что есть ломбок, но у меня IDEA ругается пока не напишешь руками геттер, сеттер или конструктор,
    //что сделать, чтобы не ругался? Причём главное код выполняется, но ИДЕЯ красным подчеркивает (!?!)
    public List<Room> getRooms() {
        return this.rooms;
    }

    public List<Food> getCollectedFood() {
        return this.collectedFood;
    }


    public static void collectFood(House house, int startRoomNumber) {
        house.getCollectedFood().addAll(house.getRooms().get(startRoomNumber).getFoodInRoom());
        System.out.println("collecting food in room " + house.getRooms().get(startRoomNumber).getName());
        house.getCollectedFood().addAll(house.getRooms().get(startRoomNumber + 1).getFoodInRoom());
        System.out.println("collecting food in room " + house.getRooms().get(startRoomNumber + 1).getName());
        //Скажи, пожалуйста, почему я не могу отсюда удалить еду из комнаты, я как только ни пробовал?
        //house.getRooms().get(startRoomNumber).getFoodInRoom().clear();
        //System.out.println("food in room " + house.getRooms().get(startRoomNumber).getName() + " is " + house.getRooms().get(startRoomNumber).getFoodInRoom());
        //house.getRooms().get(startRoomNumber + 1).deleteFoodInRoom();

    }

    public void initialize() {
        Food food11 = new Food("beef", 1.2);
        Food food12 = new Food("cheeze", 1.2);
        Food food21 = new Food("cheeze", 2);
        Food food31 = new Food("beef", 3);
        Food food41 = new Food("egg", 3);
        Food food42 = new Food("beef", 1);
        Food food43 = new Food("cheeze", 2);
        Food food51 = new Food("beef", 0.2);
        Food food61 = new Food("egg", 1.2);
        Food food71 = new Food("cheeze", 0.5);
        Food food81 = new Food("beef", 1.2);
        Food food91 = new Food("egg", 0.3);
        Food food101 = new Food("beef", 0.3);
        Food food102 = new Food("beef", 1.2);
        Room room1 = new Room("0", Arrays.asList(food11, food12));
        Room room2 = new Room("1", Arrays.asList(food21));
        Room room3 = new Room("2", Arrays.asList(food31));
        Room room4 = new Room("3", Arrays.asList(food41, food42, food43));
        Room room5 = new Room("4", Arrays.asList(food51));
        Room room6 = new Room("5", Arrays.asList(food61));
        Room room7 = new Room("6", Arrays.asList(food71));
        Room room8 = new Room("7", Arrays.asList(food81));
        Room room9 = new Room("8", Arrays.asList(food91));
        Room room10 = new Room("9", Arrays.asList(food101, food102));
        //List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);
        rooms.add(room10);
        //List<Food> collectedFood = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException {
        House house = new House(new ArrayList<>(), new ArrayList<>());
        house.initialize();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Runnable task = () -> {
                collectFood(house, 2 * finalI);
                //fix static error?
                //System.out.println(house.getRooms());
            };
            executor.schedule(task, 30 * i , TimeUnit.SECONDS);
        }
        try {
            executor.awaitTermination(150, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdownNow();
        System.out.println("Food is gathered, here is the list:");
        house.getCollectedFood().stream().forEach(food -> System.out.println(food.name + " " + food.quantity));
        //house.getRooms().stream().forEach(room -> room.getFoodInRoom().clear());
        //эта строчка выдаёт ошибку, я не понимаю, почему, подскажи, пожалуйста, почему я не могу комнаты очистить?
        System.out.println("Food in rooms now:");
        house.getRooms().stream().forEach(room -> System.out.println(room.getFoodInRoom()));
    }
}
