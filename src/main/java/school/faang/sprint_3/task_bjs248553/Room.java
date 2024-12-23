package school.faang.sprint_3.task_bjs248553;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Room {
    public static final int MILLIS_EMULATE_COLLECTING_FOOD = 2000;

    private final int number;
    private List<Food> foods;

    @SneakyThrows
    public List<Food> collectFood() {
        ArrayList<Food> result = new ArrayList<>(foods);

        Thread.sleep(MILLIS_EMULATE_COLLECTING_FOOD);

        foods = new ArrayList<>();
        return result;
    }
}
