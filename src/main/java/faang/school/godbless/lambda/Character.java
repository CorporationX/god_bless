package faang.school.godbless.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {

    private String name;
    private List<Item> inventory;
}
