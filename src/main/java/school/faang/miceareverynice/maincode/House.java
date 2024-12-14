package school.faang.miceareverynice.maincode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class House {
    private List<Room> rooms;
    private List<Food> collectedFood;

    public House() {
        rooms = new ArrayList<>();
        collectedFood = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void collectFood() {
        Random random = new Random();


        if (rooms.size() < 2) {
            System.out.println("Недостаточно комнат");
            return;
        }

        int firstRandomIndex = random.nextInt(rooms.size());
        int secondRandomIndex;
        do {
            secondRandomIndex = random.nextInt(rooms.size());
        } while (secondRandomIndex == firstRandomIndex);


        Room firstRoom = rooms.get(firstRandomIndex);
        Room secindRoom = rooms.get(secondRandomIndex);

        collectFoodFromRoom(firstRoom);
        collectFoodFromRoom(secindRoom);

        System.out.println("Еда собрана из комнат " + firstRoom + " и " + secindRoom);
    }

    private void collectFoodFromRoom(Room room) {
        collectedFood.addAll(room.getFoods());
        room.getFoods().clear();
    }
}
