package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class House {
    private List<Room> rooms = new ArrayList<>();
    private List<Food> food = new ArrayList<>();

    public void collectFood() {
        for (int i = 0; i < rooms.size(); i+=2) {
            food.addAll(rooms.get(i).getFoodInThisRoom());
            rooms.get(i).getFoodInThisRoom().clear();
            food.addAll(rooms.get(i+1).getFoodInThisRoom());
            rooms.get(i+1).getFoodInThisRoom().clear();
        }
    }
}
