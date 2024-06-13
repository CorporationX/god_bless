package faang.school.godbless.BJS2_9045;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
public class Character {
    String name;
    List<Item> inventory;
}
