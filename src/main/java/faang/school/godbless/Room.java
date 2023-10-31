package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private String name;
    private List<Food> foodList;
}

