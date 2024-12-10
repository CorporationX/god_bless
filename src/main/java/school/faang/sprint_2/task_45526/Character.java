package school.faang.sprint_2.task_45526;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Character {
    @NonNull
    private final String name;
    @NonNull
    private final List<Item> inventory = new ArrayList<>();
}
