package school.faang.bjs248710;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@ToString
public class House {
    private static final int STREAM_SIZE = 2;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    public House(List<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    public void collectFood() {
        foods.addAll(new Random().ints(STREAM_SIZE, 0, rooms.size())
                .mapToObj(n -> rooms.get(n).collectFoods())
                .flatMap(List::stream)
                .toList());
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }

    public void printFoodsSizes() {
        System.out.printf("global foods = %s, foods in rooms = %s\n", foods.size(),
                rooms.stream().map(room -> room.getFoods().size()).reduce(0, Integer::sum));
    }
}
