package faang.school.godbless;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor()
public class Character {
    @NonNull
    private String name;
    private List<Item> inventory = new ArrayList<>();
}
