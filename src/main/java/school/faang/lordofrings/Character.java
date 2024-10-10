package school.faang.lordofrings;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
}