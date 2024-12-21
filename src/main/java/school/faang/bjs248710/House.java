package school.faang.bjs248710;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;

@Getter
@ToString
public class House {
    private static final int STREAM_SIZE = 2;
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();
    private final Consumer<ScheduledExecutorService> callback;

    public House(List<Room> rooms, Consumer<ScheduledExecutorService> callback) {
        this.callback = callback;
        this.rooms.addAll(rooms);
        printFoodsSizes();
    }

    public void collectFood(ScheduledExecutorService executor) {
        foods.addAll(new Random().ints(STREAM_SIZE, 0, rooms.size())
                .mapToObj(n -> rooms.get(n).collectFoods())
                .flatMap(List::stream)
                .toList());

        if (allFoodCollected()) {
            callback.accept(executor);
            printFoodsSizes();
        }
    }

    public boolean allFoodCollected() {
        return rooms.stream().allMatch(room -> room.getFoods().isEmpty());
    }

    public void printFoodsSizes() {
        System.out.printf("global foods = %s, foods in rooms = %s\n", foods.size(),
                rooms.stream().map(room -> room.getFoods().size()).reduce(0, Integer::sum));
    }
}
