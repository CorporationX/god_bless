package faang.school.godbless.sprint3.miceAreVeryNice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class House {

    private final List<Room> rooms;
    private List<Food> collectedFood;


    public House(List<Room> rooms, List<Food> collectedFood) {
        this.rooms = rooms;
        this.collectedFood = collectedFood;
    }


    public void collectFood() {
        synchronized (rooms) {

            rooms.forEach(room -> {
                collectedFood.addAll(room.getFoods());
                room.getFoods().clear();
            });
        }
    }
}
