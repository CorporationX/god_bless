package school.faang.sprint_1.task_miceareverynicebjs2n48375;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.List;

@Getter
@AllArgsConstructor
public class Room {
    @NonNull
    private List<Food> food;

    public void removeFood () {
        food.clear();
    }
}
