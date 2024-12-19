package school.faang.sprint_1.task_miceareverynicebjs2n48375;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Room {
    @NonNull
    private List<Food> food;

    public void removeFood() {
        food.clear();
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
