package school.faang.sprint3.homes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        this.collectedFood = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат для сбор еды.");
        }

        Random random = new Random();
        Room room1 = rooms.get(random.nextInt(rooms.size()));
        Room room2 = rooms.get(random.nextInt(rooms.size()));

        while (room1 == room2) {
            room2 = rooms.get(random.nextInt(rooms.size()));
        }
        if (room1.hasFood() && room2.hasFood()) {
            Food foodFromRoom1 = room1.getFoods().get(0);
            Food foodFromRoom2 = room2.getFoods().get(0);

            collectedFood.add(foodFromRoom1);
            collectedFood.add(foodFromRoom2);
            room1.removeFood(foodFromRoom1);
            room2.removeFood(foodFromRoom2);

            System.out.println("Собрана еда: "+ foodFromRoom1.getName()+" и " +foodFromRoom2.getName());
        }else {
            System.out.println("Один из выбраных комната пуста.");
        }
    }
    public void showCollectedFood(){
        System.out.println("Собранная еда: ");
        for (Food food : collectedFood){
            System.out.println(food.getName());
        }
    }
}
