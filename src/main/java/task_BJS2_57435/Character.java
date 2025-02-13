package task_BJS2_57435;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

}
