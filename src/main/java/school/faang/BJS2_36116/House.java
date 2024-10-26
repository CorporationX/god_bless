package school.faang.BJS2_36116;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void initialize() {
        Room room1 = new Room(1);
        room1.addFood(new Food("Сыр"));
        room1.addFood(new Food("Хлеб"));

        Room room2 = new Room(2);
        room2.addFood(new Food("Колбаса"));
        room2.addFood(new Food("Яблоко"));

        Room room3 = new Room(3);
        room3.addFood(new Food("Печенье"));
        room3.addFood(new Food("Шоколад"));

        Room room4 = new Room(4);
        room4.addFood(new Food("Молоко"));
        room4.addFood(new Food("Кекс"));

        Room room5 = new Room(5);
        room5.addFood(new Food("Ягоды"));
        room5.addFood(new Food("Фрукты"));

        Room room6 = new Room(6);
        room6.addFood(new Food("Чипсы"));
        room6.addFood(new Food("Орехи"));

        Room room7 = new Room(7);
        room7.addFood(new Food("Салями"));
        room7.addFood(new Food("Помидоры"));

        Room room8 = new Room(8);
        room8.addFood(new Food("Устрицы"));
        room8.addFood(new Food("Креветки"));

        Room room9 = new Room(9);
        room9.addFood(new Food("Тортик"));
        room9.addFood(new Food("Карамель"));

        Room room10 = new Room(10);
        room10.addFood(new Food("Пицца"));
        room10.addFood(new Food("Суши"));

        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
        addRoom(room4);
        addRoom(room5);
        addRoom(room6);
        addRoom(room7);
        addRoom(room8);
        addRoom(room9);
        addRoom(room10);
    }


    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат для сбора еды");
            return;
        }

        Random random = new Random();
        int room1Index = random.nextInt(rooms.size());
        int room2Index;

        do {
            room2Index = random.nextInt(rooms.size());
        } while (room1Index == room2Index);

        Room room1 = rooms.get(room1Index);
        Room room2 = rooms.get(room2Index);

        synchronized (room1) {
            synchronized (room2) {
                if (room1.hasFood() || room2.hasFood()) {
                    List<Food> collectedFromRoom1 = room1.hasFood() ? room1.removeAllFood() : Collections.emptyList();
                    List<Food> collectedFromRoom2 = room2.hasFood() ? room2.removeAllFood() : Collections.emptyList();

                    collectedFood.addAll(collectedFromRoom1);
                    collectedFood.addAll(collectedFromRoom2);

                    System.out.println("Собрана еда из комнат:");
                    collectedFromRoom1.forEach(food -> System.out.println("- " + food.getName() + " из комнаты " + (room1Index + 1)));
                    int finalRoom2Index = room2Index;
                    collectedFromRoom2.forEach(food -> System.out.println("- " + food.getName() + " из комнаты " + (finalRoom2Index + 1)));
                }
            }
        }

        if (isAllFoodCollected()) {
            System.out.println("Еда в доме собрана!");
        }
    }

    public boolean isAllFoodCollected() {
        for (Room room : rooms) {
            if (room.hasFood()) {
                return false;
            }
        }
        return true;
    }
}
