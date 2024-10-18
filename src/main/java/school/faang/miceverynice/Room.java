package school.faang.miceverynice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Room {
    private List<Food> foods;

    public boolean hasFood(){
        return !foods.isEmpty();
    }
}
