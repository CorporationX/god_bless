package school.faang.micearenice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@ToString
public class Room {
    private List<Food> foods;

    public void removeFood(){
        foods = new ArrayList<>();
    }
}
