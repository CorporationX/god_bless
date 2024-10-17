package school.faang.miceAreVeryNice;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> collectedFood = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        int firstRandomNumber = (int) (Math.random() * rooms.size());
        int secondRandomNumber = firstRandomNumber;
        while (secondRandomNumber == firstRandomNumber) {
            secondRandomNumber = (int) (Math.random() * rooms.size());
        }

        Room firstRoom = rooms.get(firstRandomNumber);
        Room secondRoom = rooms.get(secondRandomNumber);

        List<Food> foodInTheFirstRoom = firstRoom.getFoods();
        collectedFood.addAll(foodInTheFirstRoom);
        foodInTheFirstRoom.clear();

        List<Food> foodInTheSecondRoom = secondRoom.getFoods();
        collectedFood.addAll(foodInTheSecondRoom);
        foodInTheSecondRoom.clear();
    }

}
