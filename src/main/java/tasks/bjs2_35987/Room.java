package tasks.bjs2_35987;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foods;

    public synchronized List<Food> collectFoods() {
        System.out.println("Поток " + Thread.currentThread().getId() + " собирает продукты из комнаты " + name);
        List<Food> collectedFood = new ArrayList<>(foods);
        foods.clear();
        System.out.println("Поток " + Thread.currentThread().getId() + " собрал продукты из комнаты " + name);
        return collectedFood;
    }

    public synchronized boolean hasFood() {
        return !foods.isEmpty();
    }
}
