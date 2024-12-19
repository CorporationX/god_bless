package school.faang.mice_nice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Setter
@Getter
@RequiredArgsConstructor
public class House {
    private final List<Room> rooms;
    private final List<Food> collectedFood = new ArrayList<>();

    public void collectFood() {
        Random random = new Random();
        IntStream.range(0, 2)
                .mapToObj(number -> rooms.get(random.nextInt(DataSet.AMOUNT_OF_ROOMS)))
                .filter(Room::hasFood)
                .map(Room::removeAllFood)
                .forEach(collectedFood::addAll);

    }

}
