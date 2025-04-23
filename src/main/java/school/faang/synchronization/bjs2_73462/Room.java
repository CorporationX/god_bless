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
    private final List<Food> foods;
    private final Object lock = new Object();

    public List<Food> pickFood() {
        synchronized (lock) {
            List<Food> foodList = new ArrayList<>(foods);
            foods.clear();
            return foodList;
        }
    }

//    public void clearRoom() {
//        synchronized (foods) {
//            foods.clear();
//        }
//    }
}
