package school.faang.miceareverynice.maincode;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Room {
    private List<Food> foods;

    public Room(List<Food> foods) {
        this.foods = foods;
    }
}
