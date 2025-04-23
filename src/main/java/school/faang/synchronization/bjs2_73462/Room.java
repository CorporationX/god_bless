package school.faang.synchronization.bjs2_73462;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Room {
    private List<Food> foods;
    private final Object lock = new Object();

    public List<Food> pickFood() {
        synchronized (lock) {
            List<Food> foodList = new ArrayList<>(foods);
            this.foods = new ArrayList<>();
            return foodList;
        }
    }

//    public void clearRoom() {
//        synchronized (foods) {
//            foods.clear();
//        }
//    }
}
