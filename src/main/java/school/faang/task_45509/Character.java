package school.faang.task_45509;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class Character {
    private final String name;
    private List<Item> inventory;
}
