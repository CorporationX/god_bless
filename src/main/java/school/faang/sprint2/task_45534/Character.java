package school.faang.sprint2.task_45534;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Character {
    @NonNull
    private final String name;
    private List<Item> items = new ArrayList<>();

}
