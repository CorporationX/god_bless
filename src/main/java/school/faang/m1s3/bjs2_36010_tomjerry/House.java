package school.faang.m1s3.bjs2_36010_tomjerry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class House {
    private static final List<Food> FOOD_STORE = new ArrayList<>();
    private List<Room> rooms;

    public void collectFood() {
        List<Room> randomRooms = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            randomRooms.add(rooms.get((int) (Math.random() * rooms.size())));
        }
        randomRooms.forEach(r -> {
            System.out.println(Thread.currentThread().getName() + " is searching " + r.getName());
            if (!r.getFood().isEmpty()) {
                System.out.println("Food in " + r.getName() + ": " + r.getFood());
                FOOD_STORE.addAll(r.getFood());
                System.out.println(Thread.currentThread().getName() + " gathers: " + r.getFood());
                r.getFood().clear();
                System.out.println("Food stock: " + FOOD_STORE + "\n");
            } else {
                System.out.println("There is no food in " + r.getName() + "\n");
            }
        });
    }
}
