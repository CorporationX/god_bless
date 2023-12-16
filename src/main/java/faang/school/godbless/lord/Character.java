package faang.school.godbless.lord;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    private List<Item> inventory;

}
