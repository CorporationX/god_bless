package faang.school.godbless.BJS2_1219;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class House {
    private List<Food> collectedFood = new ArrayList<>();
    private List<Room> rooms;


    public void collectFood() {
        int count = 0;
        for (Room room : rooms) {
            if (count >= 2 || room.getFoods().isEmpty()) {
                continue;
            }
            collectedFood.addAll(room.getFoods());
            room.getFoods().clear();
            count++;
        }
    }

    public void initialize() {
        List<Food> foods1 = new ArrayList<>(List.of(new Food("Apple"), new Food("Banana")));
        List<Food> foods2 = new ArrayList<>(List.of(new Food("Bread"), new Food("Donut")));
        List<Food> foods3 = new ArrayList<>(List.of(new Food("Olivie"), new Food("Hamburger")));
        List<Food> foods4 = new ArrayList<>(List.of(new Food("Chicken"), new Food("French fries")));
        List<Food> foods5 = new ArrayList<>(List.of(new Food("Sausage"), new Food("Wings")));
        List<Food> foods6 = new ArrayList<>(List.of(new Food("Coke"), new Food("Pizza")));

        this.rooms = new ArrayList<>(List.of(new Room(foods1), new Room(foods2), new Room(foods3), new Room(foods4), new Room(foods5), new Room(foods6)));
    }
}