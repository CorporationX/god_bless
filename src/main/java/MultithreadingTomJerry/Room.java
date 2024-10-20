package MultithreadingTomJerry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Room {
    private List<Food> foods = new ArrayList<Food>();

    public boolean hasFood() {
        return !foods.isEmpty();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(foods, room.foods);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(foods);
    }
}
