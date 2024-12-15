package school.faang.sprint_2.task_45594;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class Character {
    @NonNull
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
