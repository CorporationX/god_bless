package school.faang.MiceAre9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private final String roomName;
    private final List<Food> foods;

    public boolean hasFood(){
        return !foods.isEmpty();
    }
}
