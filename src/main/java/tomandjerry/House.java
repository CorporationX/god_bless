package tomandjerry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms;
    private final List<Food> grabbedFood;
    private final Random random;

    public House() {
        this.rooms = new ArrayList<>();
        this.grabbedFood = new ArrayList<>();
        this.random = new Random();
    }

    public static void main(String[] args) {
        House house = new House();

        System.out.println("Начало работы программы");

        Room attic = new Room("Чердак");
        attic.addFood(new Food("Протухший Сыр"));
        attic.addFood(new Food("Чёрствый Хлеб"));
        attic.addFood(new Food("Червивое Яблоко"));

        Room kitchen = new Room("Кухня");
        kitchen.addFood(new Food("Японский омлет"));
        kitchen.addFood(new Food("Сыр с дырочками"));
        kitchen.addFood(new Food("Пицца с ананасом"));

        Room bedroom = new Room("Спальня");
        bedroom.addFood(new Food("Чипсы с морской солью"));
        bedroom.addFood(new Food("Пиво две банки"));
        bedroom.addFood(new Food("Фисташки с солью"));

        Room childsroom = new Room("Чердак");
        childsroom.addFood(new Food("Макароны с кетчупом"));
        childsroom.addFood(new Food("Сосиски отварные"));
        childsroom.addFood(new Food("Куриные наггетсы"));

        house.addRoom(attic);
        house.addRoom(kitchen);
        house.addRoom(bedroom);
        house.addRoom(childsroom);

        int numberOfThreads = 5;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(numberOfThreads);

        Runnable grabFoodTask = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " начал выполнение задачи по сбору еды.");

            try {
                if (house.isFoodInHouse()) {
                    house.grabAllFood();
                } else {
                    System.out.println("Том и Джерри собрали всю еду в доме");
                    executorService.shutdown();
                    List<Food> grabbedFood = house.getGrabbedFood();
                    System.out.println("Вот все, что собрали: " + grabbedFood);
                }

            } catch (Exception error) {
                System.err.println("Ошибка при сборе еды: " + error.getMessage());
                error.printStackTrace();

                throw new IllegalStateException("Ошибка в задаче сбора еды: " + error.getMessage(), error);
            }
            System.out.println(threadName + " завершил выполнение задачи по сбору еды.");
        };

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.scheduleAtFixedRate(
                    grabFoodTask,
                    0,
                    30,
                    TimeUnit.SECONDS
            );
        }

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
                System.out.println("Пришлось принудительно остановить потоки.");
            }

        } catch (Exception error) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("Главный поток прервался");
            error.printStackTrace();
        }
        System.out.println("Задача по сбору еды успешно завершена");
    }

    private List<Room> getRoomsWithFood() {
        List<Room> roomsWithFood = new ArrayList<>();
        for (Room room : rooms) {
            if (room.hasFood()) {
                roomsWithFood.add(room);
            }
        }
        return roomsWithFood;
    }

    private Room getRandomRoom(List<Room> roomList) {
        int index = random.nextInt(roomList.size());
        return roomList.get(index);
    }

    private List<Food> grabFoodFromRoom(Room room) {
        List<Food> foodInRoom = room.getFoodList();
        List<Food> grabbedFood = new ArrayList<>(foodInRoom);

        room.clearFood();

        return grabbedFood;
    }

    private List<Food> getGrabbedFood() {
        return new ArrayList<>(grabbedFood);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public boolean isFoodInHouse() {
        return rooms.stream().anyMatch(Room::hasFood);
    }

    public void grabAllFood() {
        try {
            synchronized (this) {
                List<Room> availableRooms = getRoomsWithFood();
                if (availableRooms.size() < 2) {
                    System.out.println("Комнат для начала сбора еды недостаточно. Добавьте больше комнат");
                    return;
                }

                Room randomRoomOne = getRandomRoom(availableRooms);
                availableRooms.remove(randomRoomOne);
                Room randomRoomTwo = getRandomRoom(availableRooms);

                String threadName = Thread.currentThread().getName();

                System.out.println(threadName + " собирает еду из комнат: " + randomRoomOne.getName() + " и " + randomRoomTwo.getName());

                List<Food> grabbedFoodFromRoomOne = grabFoodFromRoom(randomRoomOne);
                List<Food> grabbedFoodFromRoomTwo = grabFoodFromRoom(randomRoomTwo);

                grabbedFood.addAll(grabbedFoodFromRoomOne);
                grabbedFood.addAll(grabbedFoodFromRoomTwo);

                System.out.println(threadName + " собрал еду: " + grabbedFoodFromRoomOne + " из " + randomRoomOne.getName() + " и " + grabbedFoodFromRoomTwo + " из " + randomRoomTwo.getName());

            }
        } catch (Exception error) {
            System.err.println("Ошибка при сборе еды: " + error.getMessage());

            error.printStackTrace();

            throw new IllegalStateException("Ошибка при сборе еды: " + error.getMessage(), error);
        }
    }
}
