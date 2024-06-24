package faang.school.godbless.mice_are_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Room {
    private String name;
    List<Food> foodInThisRoom = new ArrayList<>();

}
