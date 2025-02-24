package school.faang.task_bjs245611;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Character {
    @NonNull
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
