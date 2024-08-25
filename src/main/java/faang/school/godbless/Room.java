package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Room {
    String name;
    List<Food> foods;
}
