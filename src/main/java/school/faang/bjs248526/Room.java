package school.faang.bjs248526;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Room {
    private final String name;
    private final List<Food> foodList;

    @Override
    public String toString() {
        return "Room{name='" + name + "', foodList=" + foodList + '}';
    }
}
