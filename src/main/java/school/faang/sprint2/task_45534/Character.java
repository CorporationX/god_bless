package school.faang.sprint2.task_45534;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Character {
    @NonNull
    private final String name;
    private final List<Item> items = new ArrayList<>();

}
