package faang.school.godbless.module.third.parallelism.mice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Room {
    private List<Food> food = new ArrayList<>();
    
    public Room() {
        this.food = putFood();
    }
    
    private List<Food> putFood() {
        return IntStream.range(0, new Random().nextInt(1,10))
            .mapToObj((index) -> new Food("RandomFood" + index))
            .toList();
    }
    
    public List<Food> gatherFood() {
        List<Food> toReturn = new ArrayList<>(food);
        food = new ArrayList<>();
        return toReturn;
    }
}
