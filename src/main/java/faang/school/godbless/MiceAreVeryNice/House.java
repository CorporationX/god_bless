package faang.school.godbless.MiceAreVeryNice;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class House {
    private List<Room> rooms;
    private List<Food> foods;

    public House(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void collectFood() {
        foods = rooms.stream().flatMap(room -> room.getFoods().stream()).toList();
        rooms.forEach(room -> room.setFoods(null));
    }
}
