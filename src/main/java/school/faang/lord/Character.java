package school.faang.lord;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Character {
    private List<Item> inventory = new ArrayList<>();
}
