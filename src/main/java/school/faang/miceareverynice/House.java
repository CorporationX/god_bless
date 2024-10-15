package school.faang.miceareverynice;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class House {

    private List<Room> listOfRooms = new ArrayList<>();
    @Getter
    private List<Food> collectedFoods = new ArrayList<>();

    Random rand = new Random();

    public void addRoom(Room room) {
        listOfRooms.add(room);
    }

    public void collectFood() {
        if (listOfRooms.isEmpty() || listOfRooms.stream().allMatch(room -> room.getFoodInThisRoom().isEmpty())) {
            System.out.println("В комнатах больше нет еды.");
            return;
        }

        int firstRoomIndex = rand.nextInt(listOfRooms.size());
        int secondRoomIndex;

        do {
            secondRoomIndex = rand.nextInt(listOfRooms.size());
        } while (secondRoomIndex == firstRoomIndex);

        Room firstRoom = listOfRooms.get(firstRoomIndex);
        Room secondRoom = listOfRooms.get(secondRoomIndex);

        if (firstRoom.getFoodInThisRoom().isEmpty() || secondRoom.getFoodInThisRoom().isEmpty()) {
            System.out.println("Недостаточно еды в комнатах для сбора.");
            return;
        }

        int firstRoomFoodIndex = rand.nextInt(firstRoom.getFoodInThisRoom().size());
        int secondRoomFoodIndex = rand.nextInt(secondRoom.getFoodInThisRoom().size());

        collectedFoods.add(firstRoom.getFoodInThisRoom().get(firstRoomFoodIndex));
        collectedFoods.add(secondRoom.getFoodInThisRoom().get(secondRoomFoodIndex));

        firstRoom.removeFood(firstRoomFoodIndex);
        secondRoom.removeFood(secondRoomFoodIndex);
    }
}
