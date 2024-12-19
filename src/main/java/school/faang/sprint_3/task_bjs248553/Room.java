package school.faang.sprint_3.task_bjs248553;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    private List<Food> foods;

    public Collection<Food> collectFood() {
        return new ArrayList<>(foods);
    }

    public void clearFood() {
        foods = new ArrayList<>();
    }
}
