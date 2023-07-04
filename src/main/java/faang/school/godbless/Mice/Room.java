package faang.school.godbless.Mice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Room {
    private List<Food> foodInRoom = new ArrayList<>();
}
