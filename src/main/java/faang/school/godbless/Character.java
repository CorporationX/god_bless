package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory;
}
